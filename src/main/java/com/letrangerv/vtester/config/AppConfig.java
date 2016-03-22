package com.letrangerv.vtester.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/1/16
 */
@Configuration
@ComponentScan("com.letrangerv.vtester")
@SuppressWarnings("unused")
public class AppConfig {
    @Qualifier("devDbConfig")
    @Autowired
    private DbConfig dbConfig;
}
