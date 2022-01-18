package com.pruebatecnica.coopeuch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
	
	 @Autowired
	 private Environment env;
	 
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/*")
	                .allowedOrigins(env.getRequiredProperty("front.url"))
	                .allowedMethods("*")
	                ;
	    }

}
