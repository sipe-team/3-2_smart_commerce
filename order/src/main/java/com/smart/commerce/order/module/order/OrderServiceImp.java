package com.smart.commerce.order.module.order;

import com.smart.commerce.order.module.order.web.OrderRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import javax.transaction.Transactional;

@Service
public class OrderServiceImp implements OrderService {
    private final @NonNull ApplicationEventPublisher events;

    public OrderServiceImp(@NonNull ApplicationEventPublisher events) {
        this.events = events;
    }


    @Transactional
    public String order(OrderRequest orderRequest) {
        Order order = createOrder(orderRequest);

        events.publishEvent(new OrderToRecipeEvent(order));
        return "success";
    }

    private Order createOrder(OrderRequest orderRequest) {
        int orderId = 1; // TODO test order id

        return new Order(orderId, orderRequest.userId(), orderRequest.storeId(), orderRequest.menuIds());
    }

}
