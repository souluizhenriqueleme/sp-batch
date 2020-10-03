package br.com.lheme.springbatch.flatfile.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.lheme.springbatch.flatfile.model.Livro;

@Configuration
public class LeituraDeArquivoDeLarguraFixaWriterConfig {
	@Bean
	public ItemWriter<Livro> leituraDeArquivoDeLarguraFixaWriter() {
		return items -> items.forEach(System.out::println);
	}
}
