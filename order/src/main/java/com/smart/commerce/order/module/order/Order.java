package com.smart.commerce.order.module.order;

import java.util.List;

public record Order(int orderId, int userId, int storeId, List<Integer> menuIds) {
}
