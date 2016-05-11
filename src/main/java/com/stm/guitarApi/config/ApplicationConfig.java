package com.stm.guitarApi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { 
	    "com.stm.guitarApi.controller",
	    "com.stm.guitarApi.service",
	    "com.stm.guitarApi.dao"})
public class ApplicationConfig {
	
}