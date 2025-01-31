package com.smart.commerce.order.module.order.support.mapper;

import com.smart.commerce.order.module.order.domain.Order;
import com.smart.commerce.order.module.payment.application.dto.PayByOrderResult;

import java.util.UUID;

public class OrderPayMapper {

    public static PayByOrderResult toResult(Order order) {
        return new PayByOrderResult(
                order.getOrderNumber().toString(),
                order.getTotalOrderAmount(),
                order.getTotalPayedAmount(),
                order.getCustomerId(),
                order.getStoreId()
        );
    }
}
