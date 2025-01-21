package com.smart.commerce.customer.global.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "customer")
public class CustomerHealthProperties {

    private String health;

    public CustomerHealthProperties(final String health) {
        this.health = health;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(final String health) {
        this.health = health;
    }
}
