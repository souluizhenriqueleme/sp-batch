package br.com.lheme.evenoddsb.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrintEvenOddStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step printEvenOddStep(IteratorItemReader<Integer> countUntilTenReader,
			FunctionItemProcessor<Integer, String> evenOddProcessor, ItemWriter<String> printWriter) {
		return stepBuilderFactory.get("printEvenOddStep")
				.<Integer, String>chunk(1)
				.reader(countUntilTenReader)
				.processor(evenOddProcessor)
				.writer(printWriter)
				.build();

	}

}
