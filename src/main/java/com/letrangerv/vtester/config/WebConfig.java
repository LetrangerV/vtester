/**
 * @(#)WebConfig.java 3/3/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.config;

import freemarker.template.TemplateException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/3/16
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
    "com.letrangerv.vtester.controller",
    "com.letrangerv.vtester.persistence",
    "com.letrangerv.vtester.service"
})
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfigurer() {
        final FreeMarkerConfigurationFactory factory = new FreeMarkerConfigurationFactory();
        factory.setTemplateLoaderPath("classpath:web/WEB-INF/ftl");
        try {
            freemarker.template.Configuration configuration = factory.createConfiguration();
            configuration.setDefaultEncoding("UTF-8");
            configuration.setOutputEncoding("UTF-8");
            configuration.setURLEscapingCharset("UTF-8");
            FreeMarkerConfigurer fmc = new FreeMarkerConfigurer();
            fmc.setConfiguration(configuration);
            return fmc;
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (TemplateException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

          return null;
    }

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setSuffix(".ftl");
        resolver.setContentType("text/html;charset=UTF-8");

        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.freeMarker();
    }
}
