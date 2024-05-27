package com.baont8.toolgenerate.configuration.dataSources;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@EnableTransactionManagement
public class ProjectCustomerConnectionJDBCConfiguration {

	@Bean("projectCustomerJDBCProperties")
	@ConfigurationProperties(prefix = "spring.datasource.project-customer-by-jdbc")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean("projectCustomerJDBCDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.project-customer-by-jdbc")
	public DataSource dataSource(
			@Qualifier("projectCustomerJDBCProperties") DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().build();
	}

	@Bean("namedParameterJdbcTemplateProjectCustomer")
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(
			@Qualifier("projectCustomerJDBCDataSource") DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	@Bean("jdbcTemplateProjectCustomer")
	public JdbcTemplate jdbcTemplate(@Qualifier("projectCustomerJDBCDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "transactionManagerProjectCustomer")
	public PlatformTransactionManager transactionManagerProjectCustomer(
			@Qualifier("projectCustomerJDBCDataSource") DataSource projectCustomerJDBCDataSource) {
		return new DataSourceTransactionManager(projectCustomerJDBCDataSource);
	}

	@Bean(name = "transactionTemplateProjectCustomer")
	public TransactionTemplate transactionTemplateProjectCustomer(@Qualifier("transactionManagerProjectCustomer") PlatformTransactionManager transactionManagerProjectCustomer) {
		return new TransactionTemplate(transactionManagerProjectCustomer);
	}
}
