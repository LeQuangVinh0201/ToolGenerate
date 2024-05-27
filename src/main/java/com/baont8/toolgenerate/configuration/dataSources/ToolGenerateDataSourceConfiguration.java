package com.baont8.toolgenerate.configuration.dataSources;

import java.util.HashMap;

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
import org.springframework.context.annotation.Primary;
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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "toolGenerateEntityManagerFactory", transactionManagerRef = "toolGenerateTransactionManager", basePackages = {
		"com.baont8.toolgenerate.repository.toolGenerate" })
public class ToolGenerateDataSourceConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(ToolGenerateDataSourceConfiguration.class);

	@Autowired
	private Environment env;

	@Primary
	@Bean("toolGenerateProperties")
	@ConfigurationProperties(prefix = "spring.datasource.tool-generate")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean("toolGenerateDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.tool-generate")
	public HikariDataSource dataSource(@Qualifier("toolGenerateProperties") DataSourceProperties dataSourceProperties) {
		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setDriverClassName(env.getProperty("spring.datasource.tool-generate.driverClassName"));
		hikariDataSource.setJdbcUrl(env.getProperty("spring.datasource.tool-generate.url"));
		hikariDataSource.setUsername(env.getProperty("spring.datasource.tool-generate.username"));
		hikariDataSource.setPassword(env.getProperty("spring.datasource.tool-generate.password"));
		hikariDataSource.setMinimumIdle(5);
		hikariDataSource.setMaximumPoolSize(10);

		return hikariDataSource;
	}

	@Primary
	@Bean("toolGenerateEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("toolGenerateDataSource") HikariDataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan(new String[] { "com.baont8.toolgenerate.entity.toolGenerate" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		String isGenerateDDL = env.getProperty("spring.jpa.tool-generate.generate-ddl");
		if (isGenerateDDL != null
				&& ("true".equalsIgnoreCase(isGenerateDDL) || "false".equalsIgnoreCase(isGenerateDDL))) {
			vendorAdapter.setGenerateDdl(BooleanUtils.toBoolean(isGenerateDDL));
		}
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.tool-generate.hibernate.ddl-auto"));
		properties.put("hibernate.dialect", env.getProperty("spring.jpa.tool-generate.hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("spring.jpa.tool-generate.show-sql"));
		properties.put("hibernate.format_sql", env.getProperty("spring.jpa.tool-generate.format-sql"));

		em.setJpaPropertyMap(properties);

		return em;
	}

	@Primary
	@Bean("toolGenerateTransactionManager")
	@ConfigurationProperties(prefix = "spring.toolgenerate")
	public PlatformTransactionManager transactionManager(
			@Qualifier("toolGenerateEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	@Primary
	@Bean
	public DataSourceInitializer dataSourceInitializer1(
			@Qualifier("toolGenerateDataSource") HikariDataSource datasource) {
		// Add array file sql want to execute at initial project
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		resourceDatabasePopulator.addScript(new ClassPathResource("db/toolGenerate/schema.sql"));
		resourceDatabasePopulator.addScript(new ClassPathResource("db/toolGenerate/init_data.sql"));

		// Setting
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(datasource);
		dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);

		try {
			dataSourceInitializer.afterPropertiesSet();
			return dataSourceInitializer;
		} catch (Exception e) {
			Throwable rootCause = getRootCause(e);
			// The database initialization SQL scripts create the necessary
			// tables. If the exception indicates that the database already
			// contains tables then ignore the exception and continue on,
			// otherwise throw the exception.
			if (rootCause.getMessage().contains("already exists")) {
				LOGGER.info("Database initialization - tables already exist: {}", rootCause.getMessage());
			} else {
				throw e;
			}
		}

		return null;
	}

	private Throwable getRootCause(Throwable throwable) {
		if (throwable.getCause() != null) {
			return getRootCause(throwable.getCause());
		}
		return throwable;
	}
}
