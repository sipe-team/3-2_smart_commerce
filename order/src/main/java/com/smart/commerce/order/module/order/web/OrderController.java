package com.smart.commerce.order.module.order.web;

import com.smart.commerce.order.module.order.application.OrderService;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/order")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
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
        
        orderService.orderToPayment(orderRequest);

        // Return a confirmation string
        return "order";
    }
}
