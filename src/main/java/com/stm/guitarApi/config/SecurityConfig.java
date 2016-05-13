package com.stm.guitarApi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@PropertySource(value = "classpath:properties/security.properties", ignoreResourceNotFound = false)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${security.username}")
	private String username;
	
	@Value("${security.password}")
	private String password;
	
	@Value("${security.rol}")
	private String rol;
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser(username).password(password).roles(rol);
    }
	
	protected void configure(HttpSecurity http) throws Exception {
	    http
	    .sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.NEVER)
	        .and()
	    .authorizeRequests()
	        .anyRequest().authenticated()
	        .and()
	    .httpBasic();
	}
	
}
