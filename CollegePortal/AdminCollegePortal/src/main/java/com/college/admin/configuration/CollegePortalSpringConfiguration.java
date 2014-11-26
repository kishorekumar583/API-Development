package com.college.admin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.college.admin.dao.configuration.DataSourceConfig;
import com.college.admin.exception.config.CollegePortalExceptionMapper;

@Configuration
@ComponentScan({ "com.college" })
@Import({ DataSourceConfig.class })
public class CollegePortalSpringConfiguration {

	@Bean
	@Scope("singleton")
	public CollegePortalExceptionMapper collegePortalExceptionMapper() {
		return new CollegePortalExceptionMapper();
	}

}
