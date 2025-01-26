package com.smart.commerce.order.module.order.infrastructure.adpter;

import com.smart.commerce.order.global.support.exception.OrderNotExistException;
import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;
import com.smart.commerce.order.module.order.application.dto.OrderRequest;
import com.smart.commerce.order.module.order.domain.Order;
import com.smart.commerce.order.module.order.domain.OrderRepository;
import com.smart.commerce.order.module.order.support.factory.OrderFactory;
import com.smart.commerce.order.module.order.support.mapper.OrderMapper;
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
    public Order getOrderById(Long orderId) {
        return orderJpaRepository.findById(orderId)
                .map(OrderMapper::toInitDomain)
                .orElseThrow(OrderNotExistException::new);
    }

    @Override
    public boolean checkOrderValid(ShoppingCart shoppingCart, OrderRequest orderRequest) {
        return true;
    }

    @Override
    public Order save(ShoppingCart shoppingCart, OrderRequest orderRequest) {
        UUID orderNumber = UUID.randomUUID();
        OrderEntity orderEntity = OrderFactory.createEntityInitBeforeDelivery(shoppingCart, orderRequest.customerId(), orderRequest.storeId(), orderNumber, orderRequest.orderType());

        return OrderMapper.toInitDomain(orderJpaRepository.save(orderEntity));
    }

    @Override
    public Order getOrderByOrderNumber(String orderNumber) {
        return orderJpaRepository.findByOrderNumber(UUID.fromString(orderNumber));
    }
}
