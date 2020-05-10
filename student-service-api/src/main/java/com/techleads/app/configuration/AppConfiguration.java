package com.techleads.app.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import com.google.common.base.Predicate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration

@EnableSwagger2
public class AppConfiguration {
	@Bean
	public HttpHeaders httpHeaders() {
		return new HttpHeaders();
	}
	/*
	 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
	 * .select() .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any())
	 * .build(); }
	 */
	 
	 @Bean
	 public Docket api() {                
	     return new Docket(DocumentationType.SWAGGER_2)          
	       .select()
	       .apis(RequestHandlerSelectors.basePackage("com.techleads.app.controller"))
//	       .paths(PathSelectors.ant("/students"))
	       .paths(PathSelectors.any())
	       .build()
	       .apiInfo(apiInfo());
	 }
	 
	
	 private ApiInfo apiInfo() {
	     return new ApiInfo(
	       "Student REST API", 
	       "Student Rest API.", 
	       "API TOS", 
	       "Terms of service", 
	       new Contact("TechLeads", "techLeads.org", "techLeads@opensource"), 
	       "License of API", "API license URL", Collections.emptyList());
	 }

}
