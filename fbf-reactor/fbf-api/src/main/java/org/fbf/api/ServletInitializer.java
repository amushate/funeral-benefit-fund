package org.fbf.api;

import javax.servlet.Filter;

import org.fbf.api.security.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class, WebSecurityConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
    	return new Class[] {  };
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{ new CORSFilter()};
    }

}
