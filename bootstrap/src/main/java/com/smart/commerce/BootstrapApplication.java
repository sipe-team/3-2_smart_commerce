package com.smart.commerce;

import com.smart.commerce.ceo.global.config.CeoConfig;
import com.smart.commerce.customer.global.config.CustomerConfig;
import com.smart.commerce.order.global.config.OrderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({
        CeoConfig.class,
        CustomerConfig.class,
        OrderConfig.class
})
@SpringBootApplication
public class BootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }

}
