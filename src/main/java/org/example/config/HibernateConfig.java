package org.example.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "org.example")
//@EnableTransactionManagement — позволяет использовать TransactionManager для управления транзакциями.
@EnableTransactionManagement
//@PropertySource — подключение файла свойств, который мы недавно создавали.
@PropertySource(value = "classpath:db.properties")
public class HibernateConfig {
    //Environment — для того, чтобы получить свойства из property файл
    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    //hibernateProperties — этот метод нужен чтобы представить свойства Hibernate в виде объекта Properties
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        return properties;
    }

    //DataSource — используется для создания соединения с БД. Это альтернатива DriverManager аналог класса main
    //возможность создания пула соединений Database Connection Pool (DBCP).
    @Bean
    public DataSource dataSource() {
        // DriverManagerDataSource dataSource = new DriverManagerDataSource();
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    //sessionFactory — для создания сессий, с помощью которых осуществляются операции с объектами-сущностями.
    // Здесь мы устанавливаем источник данных, свойства Hibernate и в каком пакете нужно искать классы-сущности.
    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("org.example.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    //transactionManager — для настройки менеджера транзакций.
    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}