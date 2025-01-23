package com.smart.commerce.order.module.order.infrastructure.adpter;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;
import com.smart.commerce.order.module.order.application.dto.OrderRequest;
import com.smart.commerce.order.module.order.domain.Order;
import com.smart.commerce.order.module.order.domain.OrderRepository;
import com.smart.commerce.order.module.order.infrastructure.mapper.OrderMapper;
import com.smart.commerce.order.module.order.infrastructure.repository.OrderJpaRepository;
import com.smart.commerce.order.module.order.infrastructure.repository.entity.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    public OrderRepositoryAdapter(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    @Override
    public boolean checkOrderValid(ShoppingCart shoppingCart, OrderRequest orderRequest) {
        return true;
    }

    @Override
    public Order save(ShoppingCart shoppingCart, OrderRequest orderRequest) {
        UUID orderNumber = UUID.randomUUID();
        OrderEntity orderEntity = OrderEntity.create(orderRequest.userId(), orderRequest.storeId(), orderNumber);
        return OrderMapper.toDomain(orderJpaRepository.save(orderEntity));
    }
}
