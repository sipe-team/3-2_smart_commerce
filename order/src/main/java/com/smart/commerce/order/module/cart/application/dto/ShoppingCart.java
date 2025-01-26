package com.smart.commerce.order.module.cart.application.dto;


import java.util.List;

public record ShoppingCart(Long storeId, Long storePrice, List<Long> menuIds){
}
