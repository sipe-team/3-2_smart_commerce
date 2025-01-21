package com.smart.commerce.order.module.order.presentation.controller;

import com.smart.commerce.order.module.order.application.dto.OrderRequest;
import com.smart.commerce.order.module.order.application.dto.OrderResponse;
import com.smart.commerce.order.module.order.application.service.OrderUsecase;
import com.smart.commerce.order.module.order.domain.Order;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/order")
@RestController
public class OrderController {

    private final OrderUsecase orderUsecase;

    public OrderController(OrderUsecase orderUsecase) {
        this.orderUsecase = orderUsecase;
    }

    @GetMapping
    public String getOrder() {
        return "order";
    }

    /**
     * Handles POST requests for creating an order.
     *
     * @param orderRequest the request body containing order details
     * @return a string indicating the outcome of the order process
     */
    @PostMapping
    public OrderResponse order(@RequestBody OrderRequest orderRequest) {
        // Process the order request using the order service

        Order order = orderUsecase.orderToPayment(orderRequest);
        OrderResponse orderResponse = OrderResponse.builder()
                .orderStatus(order.getOrderStatus())
                .orderNumber(order.getOrderNumber())
                .build();

        // Return a confirmation string
        return orderResponse;
    }
}