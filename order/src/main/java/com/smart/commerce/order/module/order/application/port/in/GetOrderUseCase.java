package com.smart.commerce.order.module.order.application.port.in;

import com.smart.commerce.order.module.order.application.service.OrderService;
import com.smart.commerce.order.module.order.domain.Order;
import com.smart.commerce.order.module.order.support.mapper.OrderPayMapper;
import com.smart.commerce.order.module.payment.application.dto.PayByOrderResult;
import com.smart.commerce.order.module.payment.application.port.out.GetOrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOrderUseCase implements GetOrderPort {

    private final OrderService orderService;

    @Override
    public PayByOrderResult getOrder(String orderNumber) {
        Order order = orderService.getOrderByOrderNumber(orderNumber);
        return OrderPayMapper.toResult(order);
    }
}
