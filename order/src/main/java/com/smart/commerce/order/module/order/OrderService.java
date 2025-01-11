package com.smart.commerce.order.module.order;

import com.smart.commerce.order.module.order.web.OrderRequest;

public interface OrderService {
    String order(OrderRequest userId);
}
