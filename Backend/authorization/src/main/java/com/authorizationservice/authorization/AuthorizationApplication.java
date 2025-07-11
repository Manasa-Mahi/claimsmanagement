package com.authorizationservice.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.authorizationservice.authorization.model.AuthenticationRequest;
import com.authorizationservice.authorization.repository.AuthRequestRepo;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class AuthorizationApplication implements CommandLineRunner{
	
	@Autowired
	AuthRequestRepo authRequestRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		AuthenticationRequest user1 = new AuthenticationRequest("Abhinav","Abhinav1");
		AuthenticationRequest user2 = new AuthenticationRequest("Manisha","Manisha2");
		AuthenticationRequest user3 = new AuthenticationRequest("Rohit","Rohit3");
		AuthenticationRequest user4 = new AuthenticationRequest("Vennela","Vennela4");
		authRequestRepo.save(user1);
		authRequestRepo.save(user2);
		authRequestRepo.save(user3);
		authRequestRepo.save(user4);
	}
	@Bean
	public Docket productApi() {
	return new Docket(DocumentationType.SWAGGER_2).select()
	.apis(RequestHandlerSelectors.basePackage("com.authorizationservice.authorization.controller")).build();
	}

}