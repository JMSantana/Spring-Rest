package com.springrest;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.springrest.spring.SpringConfig;

@Configuration
@Import(value = {
        SpringConfig.class})
public class WebApplicationContextConfiguration {

}
