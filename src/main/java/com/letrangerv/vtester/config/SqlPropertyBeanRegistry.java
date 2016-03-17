/**
 * @(#)SqlPropertyBeanRegistry.java 3/17/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/17/16
 */
@Configuration
public class SqlPropertyBeanRegistry {
    @Bean
    public Properties quiz() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("src/main/resources/sql/option/quiz.xml"));
        Properties properties = null;
        try {
            propertiesFactoryBean.afterPropertiesSet();
            properties = propertiesFactoryBean.getObject();
        } catch (IOException e) {
            System.out.println("Cannot load properties file");
        }
        return properties;
    }

    @Bean
    public Properties question() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("src/main/resources/sql/option/question.xml"));
        Properties properties = null;
        try {
            propertiesFactoryBean.afterPropertiesSet();
            properties = propertiesFactoryBean.getObject();
        } catch (IOException e) {
            System.out.println("Cannot load properties file");
        }
        return properties;
    }

    @Bean
    public Properties option() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();          //generify this based on method name, do a for cycle
        propertiesFactoryBean.setLocation(new ClassPathResource("src/main/resources/sql/option/option.xml"));
        Properties properties = null;
        try {
            propertiesFactoryBean.afterPropertiesSet();
            properties = propertiesFactoryBean.getObject();
        } catch (IOException e) {
            System.out.println("Cannot load properties file");
        }
        return properties;
    }
}
