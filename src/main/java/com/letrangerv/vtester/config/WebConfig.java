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
import java.util.Locale;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/3/16
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.letrangerv.vtester.controller")
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
//            configuration.setEncoding(new Locale("ru"), "utf-8");
//            configuration.setDefaultEncoding();
            FreeMarkerConfigurer fmc = new FreeMarkerConfigurer();
            fmc.setConfiguration(configuration);
//            fmc.setTemplateLoaderPath("/WEB-INF/");
            return fmc;
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (TemplateException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

//        freemarker.template.Configuration cfg = new freemarker.template.Configuration();
//        cfg.setTemplateLoader(new MultiTemplateLoader(
//            new TemplateLoader[]{
//                new ClassTemplateLoader(FreeMarkerConfig.class, "/WEB-INF/")
//            }
//        ));

          return null;
    }

//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/");
//        resolver.setSuffix(".ftl");
//        return resolver;
//    }

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setPrefix();
//        resolver.setPrefix("/WEB-INF/");
//        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
//        resolver.setContentType("text/html;charset=UTF-8");
//        resolver

        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.freeMarker();
    }
}
