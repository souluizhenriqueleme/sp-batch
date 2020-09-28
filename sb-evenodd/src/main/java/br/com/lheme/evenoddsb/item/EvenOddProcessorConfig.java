package br.com.lheme.evenoddsb.item;

import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EvenOddProcessorConfig{


	@Bean
	public FunctionItemProcessor<Integer, String> evenOddProcessor() {
		return new FunctionItemProcessor<Integer, String>
		(item -> item %2 == 0 ? String.format("Item %s is Even", item) : String.format("Item %s id Odd", item));
	}

}
