package br.com.lheme.evenoddsb.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class EvenOddBatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job printEvenOddJob(Step printEvenOddStep) {
		return jobBuilderFactory.get("printEvenOddJob")
				.start(printEvenOddStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
