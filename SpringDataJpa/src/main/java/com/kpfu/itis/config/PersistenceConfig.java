package com.kpfu.itis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate3.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = "com.kpfu.itis")
@PropertySource("/WEB-INF/Spring/application.properties")
@EnableJpaRepositories(basePackages = "com.kpfu.itis.repository")
@EnableTransactionManagement
public class PersistenceConfig {

    @Inject
    Environment env;

    @Autowired
    private DataSource dataSource;

   @Bean
   public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setPackagesToScan("com.kpfu.itis.model");
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
    }

   @Bean
   public JpaVendorAdapter jpaVendorAdapter() {
       HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
       hibernateJpaVendorAdapter.setDatabase(Database.DERBY);
       hibernateJpaVendorAdapter.setShowSql(true);
       hibernateJpaVendorAdapter.setDatabasePlatform(env.getProperty("database.hibernate.dialect"));
       hibernateJpaVendorAdapter.setGenerateDdl(true);
       return hibernateJpaVendorAdapter;
   }

   @Bean
   public JpaTransactionManager transactionManager() {
       JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
       jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
       return jpaTransactionManager;
   }

    @Bean
    public PersistenceExceptionTranslator persistenceExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }
}
