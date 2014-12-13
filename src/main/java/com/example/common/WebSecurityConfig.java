package com.example.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	CsrfTokenResponseHeaderBindingFilter csrfFilter = csrfTokenResponseHeaderBindingFilter();
    	
        http
        	.addFilterAfter(csrfFilter, CsrfFilter.class)
        	.headers()
				.cacheControl()
				.xssProtection()
				.and()
            .authorizeRequests()
                .antMatchers(
                	"/",
                	"/common/vendor/bootstrap-3.2.0/dist/css/bootstrap.min.css",
                	"/common/vendor/spring-security-csrf-token-interceptor-0.1.5/dist/spring-security-csrf-token-interceptor.min.js",
                	"/common/vendor/spring-security-csrf-token-interceptor-0.1.5/src/spring-security-csrf-token-interceptor.js",
                	"/css/style.css",
                	"/js/controllers/MainCtrl.js",
                	"/js/appRoutes.js",
                	"/js/app.js",
                	"/views/login_view.html"
                	).permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("u").password("p").roles("USER");
    }
    
    @Bean
    public CsrfTokenResponseHeaderBindingFilter csrfTokenResponseHeaderBindingFilter() {
    	return new CsrfTokenResponseHeaderBindingFilter();
    }
}