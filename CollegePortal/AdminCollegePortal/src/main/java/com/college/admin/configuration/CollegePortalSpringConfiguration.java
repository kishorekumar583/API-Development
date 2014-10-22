package com.college.admin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.college.admin.exception.config.CollegePortalExceptionMapper;

@Configuration
@ComponentScan({ "com.college" })
public class CollegePortalSpringConfiguration {

	@Bean
	@Scope("singleton")
	public CollegePortalExceptionMapper collegePortalExceptionMapper() {
		return new CollegePortalExceptionMapper();
	}

}
