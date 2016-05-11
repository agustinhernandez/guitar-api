package com.stm.guitarApi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { 
	    "com.stm.guitarApi.service",
	    "com.stm.guitarApi.dao"})
public class TestApplicationConfig {

}
