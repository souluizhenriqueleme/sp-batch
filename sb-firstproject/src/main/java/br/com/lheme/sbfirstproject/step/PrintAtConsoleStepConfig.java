package br.com.lheme.sbfirstproject.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrintAtConsoleStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step printAtConsoleStep(Tasklet printAtConsoleTasklet) {
		return stepBuilderFactory
				.get("printAtConsoleStep")
				.tasklet(printAtConsoleTasklet)
				.build();
	}
}
