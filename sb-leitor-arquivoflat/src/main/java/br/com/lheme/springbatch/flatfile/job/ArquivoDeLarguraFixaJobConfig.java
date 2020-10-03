package br.com.lheme.springbatch.flatfile.job;

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
public class ArquivoDeLarguraFixaJobConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job arquivoDeLarguraFixaJob(Step leituraDeArquivoDeLarguraFixaStep) {
		return jobBuilderFactory
				.get("arquivoDeLarguraFixaJob")
				.start(leituraDeArquivoDeLarguraFixaStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
