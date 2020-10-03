package br.com.lheme.springbatch.flatfile.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.lheme.springbatch.flatfile.model.Livro;

@Configuration
public class LeituraDeArquivoDeLarguraFixaReaderConfig {

	@Bean
	public FlatFileItemReader<Livro> leituraDeArquivoDeLarguraFixaReader() {
		return null;
	}
}
