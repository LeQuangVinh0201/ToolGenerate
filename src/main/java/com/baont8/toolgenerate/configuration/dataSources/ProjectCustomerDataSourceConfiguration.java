package com.baont8.toolgenerate.configuration.dataSources;

import java.util.HashMap;

import javax.sql.DataSource;

import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "projectCustomerEntityManagerFactory", transactionManagerRef = "projectCustomerTransactionManager", basePackages = {
//		"com.baont8.toolgenerate.repository.projectCustomer" })
public class ProjectCustomerDataSourceConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectCustomerDataSourceConfiguration.class);

//	@Autowired
//	private Environment env;

//	@Bean("projectCustomerProperties")
//	@ConfigurationProperties(prefix = "spring.datasource.project-customer")
//	public DataSourceProperties dataSourceProperties() {
//		return new DataSourceProperties();
//	}

//	@Bean("projectCustomerDataSource")
//	@ConfigurationProperties(prefix = "spring.datasource.project-customer")
//	public HikariDataSource dataSource(@Qualifier("projectCustomerProperties") DataSourceProperties dataSourceProperties) {
//		HikariDataSource hikariDataSource = new HikariDataSource();
//		hikariDataSource.setDriverClassName(env.getProperty("spring.datasource.project-customer.driverClassName"));
//		hikariDataSource.setJdbcUrl(env.getProperty("spring.datasource.project-customer.url"));
//		hikariDataSource.setUsername(env.getProperty("spring.datasource.project-customer.username"));
//		hikariDataSource.setPassword(env.getProperty("spring.datasource.project-customer.password"));
//		hikariDataSource.setMinimumIdle(5);
//		hikariDataSource.setMaximumPoolSize(10);
//
//		return hikariDataSource;
//	}

//	@Bean("projectCustomerEntityManagerFactory")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
//			@Qualifier("projectCustomerDataSource") DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource);
//        em.setPackagesToScan(new String[] { "com.baont8.toolgenerate.entity.projectCustomer" });
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        String isGenerateDDL = env.getProperty("spring.jpa.project-customer.generate-ddl");
//        if (isGenerateDDL != null && ("true".equalsIgnoreCase(isGenerateDDL) || "false".equalsIgnoreCase(isGenerateDDL))) {
//        	vendorAdapter.setGenerateDdl(BooleanUtils.toBoolean(isGenerateDDL));
//        }
//        em.setJpaVendorAdapter(vendorAdapter);
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", "none"); // VERY IMPORTANT DONT CHANGE DDL AUTO. BECAUSE THIS IS DDL OF projectCustomer SYSTEM
//        properties.put("hibernate.dialect", env.getProperty("spring.jpa.project-customer.hibernate.dialect"));
//        properties.put("hibernate.show_sql", env.getProperty("spring.jpa.project-customer.show-sql"));
//        properties.put("hibernate.format_sql", env.getProperty("spring.jpa.project-customer.format-sql"));
//        
//        em.setJpaPropertyMap(properties);
//      
//      return em;
//	}

//	@Bean("projectCustomerTransactionManager")
//	@ConfigurationProperties(prefix = "spring.projectcustomer")
//	public PlatformTransactionManager transactionManager(
//			@Qualifier("projectCustomerEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//		return new JpaTransactionManager(entityManagerFactory);
//	}

//	@Bean
//	public DataSourceInitializer dataSourceInitializer2(
//			@Qualifier("projectCustomerDataSource") HikariDataSource datasource) {
//		// Add array file sql want to execute at initial project
//		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
//		resourceDatabasePopulator.addScript(new ClassPathResource("db/projectCustomer/schema.sql"));
//		resourceDatabasePopulator.addScript(new ClassPathResource("db/projectCustomer/schema22.sql"));
//
//		// Setting
//		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
//		dataSourceInitializer.setDataSource(datasource);
//		dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
//
//		try {
//			dataSourceInitializer.afterPropertiesSet();
//			return dataSourceInitializer;
//		} catch (Exception e) {
//			Throwable rootCause = getRootCause(e);
//			// The database initialization SQL scripts create the necessary
//			// tables. If the exception indicates that the database already
//			// contains tables then ignore the exception and continue on,
//			// otherwise throw the exception.
//			if (rootCause.getMessage().contains("already exists")) {
//				LOGGER.info("Database initialization - tables already exist: {}", rootCause.getMessage());
//			} else {
//				throw e;
//			}
//		}
//
//		return null;
//	}

	private Throwable getRootCause(Throwable throwable) {
		if (throwable.getCause() != null) {
			return getRootCause(throwable.getCause());
		}
		return throwable;
	}

}
