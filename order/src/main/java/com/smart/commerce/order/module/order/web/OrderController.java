package com.smart.commerce.order.module.order.web;

import com.smart.commerce.order.module.order.OrderService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping
    public String order(@RequestBody OrderRequest orderRequest) {
        orderService.order(orderRequest);
        return "order";
    }
}
