package com.smart.commerce;

import com.smart.commerce.ceo.global.config.properties.CeoHealthProperties;
import com.smart.commerce.customer.global.config.properties.CustomerHealthProperties;
import com.smart.commerce.order.global.config.properties.OrderHealthProperties;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProfileChecker {

    private static final Logger logger = LoggerFactory.getLogger(ProfileChecker.class);

    private final CeoHealthProperties ceoHealthProperties;
    private final CustomerHealthProperties customerHealthProperties;
    private final OrderHealthProperties orderHealthProperties;

    public ProfileChecker(final CeoHealthProperties ceoHealthProperties,
                          final CustomerHealthProperties customerHealthProperties,
                          final OrderHealthProperties orderHealthProperties) {
        this.ceoHealthProperties = ceoHealthProperties;
        this.customerHealthProperties = customerHealthProperties;
        this.orderHealthProperties = orderHealthProperties;
    }

    @PostConstruct
    public void getSomeData() {
        logger.info("CEO Health: {}", ceoHealthProperties.getHealth());
        logger.info("CUSTOMER Health: {}", customerHealthProperties.getHealth());
        logger.info("ORDER Health: {}", orderHealthProperties.getHealth());
    }
}
