package com.smart.commerce.order.module.order.domain;

import java.util.List;

public record OrderRecord(int orderId, int userId, int storeId, List<Long> menuIds) {
}
