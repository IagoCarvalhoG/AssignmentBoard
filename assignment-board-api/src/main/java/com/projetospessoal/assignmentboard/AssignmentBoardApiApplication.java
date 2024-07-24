package com.projetospessoal.assignmentboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.projetospessoal.assignmentboard.filters.AuthFilters;

@SpringBootApplication
public class AssignmentBoardApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentBoardApiApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<AuthFilters> filterRegistrationBean(){
		FilterRegistrationBean<AuthFilters> registrationBean = new FilterRegistrationBean<>();
		AuthFilters authFilters = new AuthFilters();
		registrationBean.setFilter(authFilters);
		registrationBean.addUrlPatterns("/api/categories/*");
		return registrationBean;
		
	}

}
