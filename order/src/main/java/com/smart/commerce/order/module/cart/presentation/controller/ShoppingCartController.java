package com.smart.commerce.order.module.cart.presentation.controller;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCartRequest;
import com.smart.commerce.order.module.cart.application.service.ShoppingCartUseCase;
import com.smart.commerce.order.module.cart.domain.ShoppingCart;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartUseCase shoppingCartUseCase;

    @PostMapping("/add")
    public void add(@RequestBody ShoppingCartRequest request) {
        shoppingCartUseCase.add(request.customerId(), request.menuId());
    }

    @PutMapping("/minus")
    public void minus(@RequestBody ShoppingCartRequest request) {
        shoppingCartUseCase.minus(request.customerId(), request.menuId());
    }

    @DeleteMapping
    public void delete(@RequestBody ShoppingCartRequest request) {
        shoppingCartUseCase.delete(request.customerId(), request.menuId());
    }

    @GetMapping
    public ShoppingCart get(@RequestParam Long customerId) {
        return shoppingCartUseCase.findCart(customerId);
    }
}
