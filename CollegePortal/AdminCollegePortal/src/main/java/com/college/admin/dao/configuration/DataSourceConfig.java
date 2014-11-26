package com.college.admin.dao.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.college.admin.dao.data.BaseDao;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.college" })
public class DataSourceConfig {

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		return new JndiDataSourceLookup().getDataSource(BaseDao.COLLEGE_JNDI_NAME);
	}

	@Bean(name = "namedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource());
	}

	/*
	 * @Bean(name = "sqlUtil") public SqlUtil sqlUtil() { return new SqlUtil();
	 * }
	 */

	@Bean(name = "txManager")
	public PlatformTransactionManager txManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager(dataSource());
		txManager.setDefaultTimeout(30);
		return txManager;
	}
}
