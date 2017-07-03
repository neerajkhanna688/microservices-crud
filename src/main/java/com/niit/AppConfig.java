package com.niit;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.service.EmployeeServiceCrudImpl;
import com.niit.service.EmployeeServiceCrudInterface;
import com.niit.service.EmployeeServiceJPAImpl;
import com.niit.service.EmployeeServiceJPAInterface;

import java.util.Properties;

import javax.sql.DataSource;

@Configuration
@PropertySource(value="application.properties")
@ComponentScan("com.niit")
@EnableTransactionManagement
@EnableJpaRepositories("com.niit.repository")
public class AppConfig {
    
	@Autowired
    private Environment environment ;

  

    @Bean
    @Primary
    DataSource dataSource() {
    	DriverManagerDataSource driverManager = new DriverManagerDataSource();
    	driverManager.setDriverClassName(this.environment.getProperty("spring.datasource.driver-class-name"));
        driverManager.setUrl(this.environment.getProperty("spring.datasource.url"));
        driverManager.setUsername(this.environment.getProperty("spring.datasource.username"));
        driverManager.setPassword(this.environment.getProperty("spring.datasource.password"));
        return driverManager;    	
        }
    
    
    @Bean 
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
    	LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
    	lcemfb.setDataSource(dataSource());
    	HibernateJpaVendorAdapter hjvAdapter = new HibernateJpaVendorAdapter();
    	lcemfb.setJpaVendorAdapter(hjvAdapter);
    	lcemfb.setJpaProperties(hibProperties());
    	lcemfb.setPackagesToScan("com.niit.model");
    	
    	return lcemfb;
    }
    
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
    
    
    
//    @Bean
//    public EmployeeServiceCrudInterface employeeServiceCrudInterface(){
//    	return new EmployeeServiceCrudImpl();
//    }
    
    private Properties hibProperties() {
        Properties properties = new Properties();
	     properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        return properties;
    }
}