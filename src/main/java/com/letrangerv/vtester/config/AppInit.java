package com.letrangerv.vtester.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletRegistration;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/3/16
 */
@SuppressWarnings("unused")
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected final Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
            WebConfig.class
        };
    }

    @Override
    protected final Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
            WebConfig.class
        };
    }

    @Override
    protected final String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected final void customizeRegistration(final ServletRegistration.Dynamic registration) {
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    }
}


