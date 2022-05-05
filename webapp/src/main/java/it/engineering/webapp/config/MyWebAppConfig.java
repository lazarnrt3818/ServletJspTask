package it.engineering.webapp.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import it.engineering.webapp.formatter.CityDtoFormatter;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = { 
		"it.engineering.webapp.controller",
		"it.engineering.webapp.service",
		"it.engineering.webapp.formatter", 
		"it.engineering.webapp.repository", 
		"it.engineering.webapp.converter"

})
public class MyWebAppConfig implements WebMvcConfigurer {

	@Autowired
	@Lazy
	private CityDtoFormatter cityDtoFormater;

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(1);
		return viewResolver;
	}

	@Bean
	public DataSource dataSource() {
		System.out.println("=============== dataSource: ApplicationConfiguration =======================");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/servletjsp");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManager(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setPackagesToScan("it.engineering.webapp.domain");
		emfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		return emfb;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(emf);
		return jpaTransactionManager;
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(cityDtoFormater);
	}

}
