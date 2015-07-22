package com.springrest;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebApplicationContextInitializer implements ApplicationContextInitializer<AnnotationConfigWebApplicationContext> {

    @Override
    public void initialize(AnnotationConfigWebApplicationContext applicationContext) {
        applicationContext.setDisplayName("hello-rest"); //$NON-NLS-1$
        applicationContext.register(WebApplicationContextConfiguration.class);
    }
}
