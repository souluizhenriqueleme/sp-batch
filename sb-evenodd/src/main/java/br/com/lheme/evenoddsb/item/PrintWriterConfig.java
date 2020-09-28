package br.com.lheme.evenoddsb.item;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrintWriterConfig {

	@Bean
	public ItemWriter<String> printWriter() {
		return item -> item.forEach(System.out::println);
	}
}
