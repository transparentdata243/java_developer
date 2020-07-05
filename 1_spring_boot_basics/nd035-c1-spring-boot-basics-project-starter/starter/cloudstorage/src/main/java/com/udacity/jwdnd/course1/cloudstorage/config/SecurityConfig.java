package com.udacity.jwdnd.course1.cloudstorage.config;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Spring Boot has built-in support for handling calls to the /login and /logout endpoints.
    // You have to use the security configuration to override the default login page with one of your own,
    // discussed in the front-end section.
}
