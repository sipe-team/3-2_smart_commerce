package com.smart.commerce.order.module.order.infrastructure.repository;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;
import com.smart.commerce.order.module.order.application.dto.OrderRequest;
import com.smart.commerce.order.module.order.domain.OrderRepository;
import com.smart.commerce.order.module.order.infrastructure.repository.entity.OrderEntity;
import org.springframework.stereotype.Component;


// TODO JPA 연동 이후 변경 예정
@Component
public class OrderJpaRepository implements OrderRepository {
    @Override
    public void checkOrderValid(ShoppingCart shoppingCart, OrderRequest orderRequest) {

    }

    // TODO JPARepository method
    @Override
    public OrderEntity save(ShoppingCart shoppingCart, OrderRequest orderRequest) {
        return null;
    }
}
