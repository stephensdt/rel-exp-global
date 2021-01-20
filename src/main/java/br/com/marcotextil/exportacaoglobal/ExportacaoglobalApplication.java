package br.com.marcotextil.exportacaoglobal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {
		"br.com.marcotextil.exportacaoglobal"
})
public class ExportacaoglobalApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ExportacaoglobalApplication.class, args);
		System.exit(0);
	}
}

