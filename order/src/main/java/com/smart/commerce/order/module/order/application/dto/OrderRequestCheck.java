package com.smart.commerce.order.module.order.application.dto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Constraint(validatedBy = OrderValidator.class)
@Target( { ElementType.PARAMETER, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderRequestCheck {
    String message() default "Shipment price doesn't match the requested price.";
    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
}