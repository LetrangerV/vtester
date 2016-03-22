package com.letrangerv.vtester.config;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/11/16
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.letrangerv.vtester.persistence")
@Import({SqlPropertyBeanRegistry.class })
@Profile("prod")
public class ProdDbConfig implements DbConfig {
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/vtester";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    @Bean
    public final DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER_NAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    @Bean
    public final PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
