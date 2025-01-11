package com.smart.commerce.order.module.cart.web;

import com.smart.commerce.order.module.cart.ShoppingCartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(path = "/shopping")
@RestController
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public void getShoppingCart(@RequestParam(defaultValue = "0") int userId) {
        shoppingCartService.getItems(userId);
        return ;
    }
}
