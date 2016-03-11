/**
 * @(#)DbConfig.java 3/11/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/11/16
 */
@Configuration
@ComponentScan("com.letrangerv.vtester.persistence")
public class DbConfig {
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:8080/vtester";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    @Bean
    public DataSource dataSource() {
        //todo connection pool
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER_NAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
}
