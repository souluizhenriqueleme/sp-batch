package br.com.lheme.springbatch.flatfile.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.lheme.springbatch.flatfile.model.Livro;

@Configuration
public class leituraDeArquivoDeLarguraFixaStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step leituraDeArquivoDeLarguraFixaStep(ItemReader<Livro> leituraDeArquivoDeLarguraFixaReader,
			ItemWriter<Livro> leituraDeArquivoDeLarguraFixaWriter) {
		return stepBuilderFactory
					.get("leituraDeArquivoDeLarguraFixaStep")
					.<Livro,Livro>chunk(1)
					.reader(leituraDeArquivoDeLarguraFixaReader)
					.writer(leituraDeArquivoDeLarguraFixaWriter)
					.build();
	}
}
