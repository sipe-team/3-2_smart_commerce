package com.smart.commerce.order.global.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "order")
public class OrderHealthProperties {

    private String health;

    public OrderHealthProperties(final String health) {
        this.health = health;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(final String health) {
        this.health = health;
    }
}
