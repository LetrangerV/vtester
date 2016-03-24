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
    "com.letrangerv.vtester.service",
    "com.letrangerv.vtester.domain",
    "com.letrangerv.vtester.config"
})
public class WebConfig extends WebMvcConfigurerAdapter {
    private static final String FREEMARKER_TEMPLATES_PATH = "classpath:web/WEB-INF/ftl";
    private static final String ENCODING = "UTF-8";
    private static final String FREEMARKER_EXT = ".ftl";
    private static final String CONTENT_TYPE = "text/html;charset=UTF-8";

    @Override
    public final void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/**").addResourceLocations("/resources/");
    }

    @Override
    public final void configureDefaultServletHandling(
        final DefaultServletHandlerConfigurer configurer
    ) {
        configurer.enable();
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfigurer() {
        final FreeMarkerConfigurationFactory factory = new FreeMarkerConfigurationFactory();
        factory.setTemplateLoaderPath(FREEMARKER_TEMPLATES_PATH);
        try {
            freemarker.template.Configuration configuration = factory.createConfiguration();
            configuration.setDefaultEncoding(ENCODING);
            configuration.setOutputEncoding(ENCODING);
            configuration.setURLEscapingCharset(ENCODING);
            FreeMarkerConfigurer fmc = new FreeMarkerConfigurer();
            fmc.setConfiguration(configuration);
            return fmc;
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setSuffix(FREEMARKER_EXT);
        resolver.setContentType(CONTENT_TYPE);

        return resolver;
    }

    @Override
    public final void configureViewResolvers(final ViewResolverRegistry registry) {
        registry.freeMarker();
    }
}
