package br.com.lheme;

import java.util.Arrays;
import java.util.List;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class EvenOddBatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job printEvenOddJob() {
		return jobBuilderFactory.get("printEvenOddJob").start(printEvenOddStep()).incrementer(new RunIdIncrementer()).build();
	}
	
	public Step printEvenOddStep() {
		return stepBuilderFactory.get("printEvenOddStep")
				.<Integer,String>chunk(1)
				.reader(countUntilTenReader())
				.processor(evenOddProcessor())
				.writer(printWriter())
				.build();
		
	}
	
	public IteratorItemReader<Integer> countUntilTenReader() {
		List<Integer> numbersOneToTen = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		return new IteratorItemReader<Integer>(numbersOneToTen.iterator());
	}
	
	public FunctionItemProcessor<Integer, String> evenOddProcessor() {
		return new FunctionItemProcessor<Integer, String>
		(item -> item %2 == 0 ? String.format("Item %s is Even", item) : String.format("Item %s id Odd", item));
	}
	
	public ItemWriter<String> printWriter() {
		return item -> item.forEach(System.out::println);
	}
}
