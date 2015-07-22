package com.springrest.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({ SpringMongoDBConfig.class, BeanConfig.class })
@Configuration
public class SpringConfig {
}
