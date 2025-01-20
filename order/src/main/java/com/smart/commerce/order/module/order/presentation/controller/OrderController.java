package com.smart.commerce.order.module.order.presentation.controller;

import com.smart.commerce.order.module.order.application.dto.OrderRequest;
import com.smart.commerce.order.module.order.application.service.OrderUsecase;
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
    public String order(@RequestBody OrderRequest orderRequest) {
        // Process the order request using the order service

        orderUsecase.orderToPayment(orderRequest);

        // Return a confirmation string
        return "order";
    }
}
