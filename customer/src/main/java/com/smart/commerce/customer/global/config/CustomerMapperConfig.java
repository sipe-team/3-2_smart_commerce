package com.smart.commerce.customer.global.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerMapperConfig {

    @Bean
    public ModelMapper customerModelMapper() {
        return new ModelMapper();
    }
}
