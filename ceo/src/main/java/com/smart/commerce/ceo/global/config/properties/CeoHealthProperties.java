package com.smart.commerce.ceo.global.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ceo")
public class CeoHealthProperties {

    private String health;

    public CeoHealthProperties(final String health) {
        this.health = health;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(final String health) {
        this.health = health;
    }
}
