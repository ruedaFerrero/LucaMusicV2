package com.payment.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Payment service API", 
				"API to validate payments", 
				"1.0", null, 
				new Contact(
						"Support team",
						"https://lucatic-grupo-v24.slack.com/archives/C02F13KBS5B",
						"support@lucaticket.es"), 
				null, 
				null,
				Collections.emptyList());
	}


}
