package com.smart.commerce;

import com.smart.commerce.ceo.global.config.properties.CeoHealthProperties;
import com.smart.commerce.order.global.config.properties.OrderHealthProperties;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ProfileChecker {

    private final CeoHealthProperties ceoHealthProperties;
    private final OrderHealthProperties orderHealthProperties;

    public ProfileChecker(final CeoHealthProperties ceoHealthProperties, final OrderHealthProperties orderHealthProperties) {
        this.ceoHealthProperties = ceoHealthProperties;
        this.orderHealthProperties = orderHealthProperties;
    }

    @PostConstruct
    public void getSomeData() {
        System.out.println("CEO Health: " + ceoHealthProperties.getHealth());
        System.out.println("ORDER Health: " + orderHealthProperties.getHealth());
    }
}
