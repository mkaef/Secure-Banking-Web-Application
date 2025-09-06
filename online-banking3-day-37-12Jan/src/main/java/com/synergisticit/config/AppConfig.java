package com.synergisticit.config;


import java.util.Properties;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class AppConfig {
	
	//@Autowired DataSource dataSource;
	
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/bankingdb?useSSL=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;

		
	}
	
	 public Properties properties() {
		 Properties properties = new Properties();
		 properties.setProperty("hibernate.hbm2ddl.auto", "update");
		 properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		 return properties;
	 }
	
	 @Bean
	 @Primary
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

	         LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	         entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	         entityManagerFactoryBean.setDataSource(dataSource());
	         entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
	         entityManagerFactoryBean.setPackagesToScan("com.synergisticit.domain");             
	         entityManagerFactoryBean.setJpaProperties(properties());

	         return entityManagerFactoryBean;
	     }
	 
	 @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan("com.synergisticit.domain");
	          
	        sessionFactory.setHibernateProperties(properties());

	        return sessionFactory;
	 }
	 
	 @Bean
	   public ViewResolver viewResolver() {
	      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	      resolver.setPrefix("/WEB-INF/jsp/");
	      resolver.setSuffix(".jsp");
	      //resolver.setOrder(1); // Setting the priority of ViewResolver
	      return resolver;
	   }
	 
	 @Bean
	 BCryptPasswordEncoder bCryptPasswordEncoder() {
		 return new BCryptPasswordEncoder();
	 } 
	
	

}
