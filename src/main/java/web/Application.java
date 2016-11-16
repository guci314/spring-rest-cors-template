package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.fasterxml.jackson.databind.Module;

import web.filters.CorsFilter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * User: brendan Date: 18/09/13 Time: 21:31
 */

@Configuration
@EnableJpaRepositories
@EnableAutoConfiguration
@ComponentScan
public class Application {

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		Properties connectionProperties = new Properties();
		// connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		//DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(
		//		"jdbc:mysql://localhost:3306/test?useUnicode=yes&characterEncoding=UTF-8", "root", "root");
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(
				"jdbc:sqlserver://192.168.6.23:1433;databaseName=test;integratedSecurity=false;", "sa", "Wchy@2015");
		// DriverManagerDataSource driverManagerDataSource = new
		// DriverManagerDataSource("jdbc:h2:mem:mydb", "root", "root");
		driverManagerDataSource.setConnectionProperties(connectionProperties);
		return driverManagerDataSource;
	}

	@Bean
	public CorsFilter getCorsFilter() {
		return new CorsFilter();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource);
		lef.setJpaVendorAdapter(jpaVendorAdapter);
		lef.setPackagesToScan("web");
		return lef;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	// @Bean
	// public Module datatypeHibernateModule() {
	// return new Hibernate4Module();
	// }

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.run(args);
	}

	/*
	 * @Bean public FilterRegistrationBean filterRegistrationBean() {
	 * FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	 * CharacterEncodingFilter characterEncodingFilter = new
	 * CharacterEncodingFilter(); characterEncodingFilter.setEncoding("UTF-8");
	 * registrationBean.setFilter(characterEncodingFilter); return
	 * registrationBean; }
	 */

}
