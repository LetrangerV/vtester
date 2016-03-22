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
    private static final String QUIZ_SQL_PATH = "src/main/resources/sql/queries/quiz.xml";
    private static final String QUESTION_SQL_PATH = "src/main/resources/sql/queries/question.xml";
    private static final String OPTION_SQL_PATH = "src/main/resources/sql/queries/option.xml";

    @Bean
    public final Properties quiz() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource(QUIZ_SQL_PATH));
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
    public final Properties question() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(
            new ClassPathResource(QUESTION_SQL_PATH)
        );
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
    public final Properties option() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(
            new ClassPathResource(OPTION_SQL_PATH)
        );
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
