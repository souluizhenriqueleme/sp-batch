package br.com.lheme;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job printAtConsoleJob() {
		return jobBuilderFactory.get("printAtConsoleJob").start(printAtConsoleStep())
				.incrementer(new RunIdIncrementer()).build();
	}

	public Step printAtConsoleStep() {
		return stepBuilderFactory.get("printAtConsoleStep").tasklet(printAtConsoleTasklet(null)).build();
	}

	@StepScope
	@Bean
	public Tasklet printAtConsoleTasklet(@Value("#{jobParameters['nome']}") String nome) {
		return new Tasklet() {
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println(String.format("First Spring Bacth Project, %s",nome));
				return RepeatStatus.FINISHED;
			}
		};
	}
}
