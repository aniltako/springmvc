package com.spring.mvc.config;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.spring.mvc.dao",entityManagerFactoryRef="localContainerEntityManagerFactoryBean")
public class MysqlDbConfig {

	@Value("${jdbc.driverClassName}")     private String driverClassName;
    @Value("${jdbc.url}")                 private String url;
    @Value("${jdbc.username}")             private String username;
    @Value("${jdbc.password}")             private String password;
    
    @Value("${hibernate.dialect}")         private String hibernateDialect;
    @Value("${hibernate.show_sql}")     private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto}") private String hibernateHbm2ddlAuto;
	
	@Bean(destroyMethod = "close")
    public DataSource getDataSource()
    {
    	
    	BasicDataSource ds = new BasicDataSource();
    	ds.setDriverClassName(driverClassName);
    	ds.setUrl(url);
    	ds.setUsername(username);
    	ds.setPassword(password);
//    	ds.setInitialSize(5);
//    	ds.setMaxActive(10);
//    	ds.setValidationQuery("select 1");
    	return ds;
//        DriverManagerDataSource ds = new DriverManagerDataSource();        
//        ds.setDriverClassName(driverClassName);
//        ds.setUrl(url);
//        ds.setUsername(username);
//        ds.setPassword(password);        
//        return ds;
    }
    
//    @Bean
//    public Properties getHibernateProperties()
//    {
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", hibernateDialect);
//        properties.put("hibernate.show_sql", hibernateShowSql);
//        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
//        
//        return properties;
//    }
    
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
    	
    	HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    	adapter.setShowSql(true);
    	adapter.setGenerateDdl(true);
    	adapter.setDatabase(Database.MYSQL);
    	
    	return adapter;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
    		DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
    	
    	LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
    	emfb.setDataSource(dataSource);
    	emfb.setJpaVendorAdapter(jpaVendorAdapter);
    	//where the entities reside
    	emfb.setPackagesToScan("com.spring.mvc.model");
    	
    	return emfb;
    }
    
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory localContainerEntityManagerFactoryBean) throws IOException{
    	JpaTransactionManager txName= new JpaTransactionManager();
        txName.setEntityManagerFactory(localContainerEntityManagerFactoryBean);
        return txName;
   }
}
