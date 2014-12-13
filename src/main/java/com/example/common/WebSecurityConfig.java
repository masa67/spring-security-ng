package com.example.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers(
                	"/",
                	"/index.html",
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
                .loginPage("/login.html")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}