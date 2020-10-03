package br.com.lheme.springbatch.flatfile.reader;


import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.lheme.springbatch.flatfile.model.Livro;

@Configuration
public class LeituraDeArquivoDeLarguraFixaReaderConfig {

	@StepScope
	@Bean
	public FlatFileItemReader<Livro> leituraDeArquivoDeLarguraFixaReader(
			@Value("#{jobParameters['arquivoLivros']}") Resource arquivoLivros) {
		return new FlatFileItemReaderBuilder<Livro>()
				.name("leituraDeArquivoDeLarguraFixaReader")
				.resource(arquivoLivros)
				.fixedLength()
				.columns(
						new Range[] {
							new Range(1,22),
							new Range(23,41),
							new Range(42,45),
							new Range(46,55)
						})
				.names(new String[] {"titulo", "autor", "editora","categoria"})
				.targetType(Livro.class)
				.build()
				;
	}
}
