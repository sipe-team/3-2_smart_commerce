package com.smart.commerce.customer.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CustomerSecurityConfig {

    @Bean
    public PasswordEncoder customerPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
