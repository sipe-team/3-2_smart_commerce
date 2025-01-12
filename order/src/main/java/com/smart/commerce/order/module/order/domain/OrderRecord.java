package com.smart.commerce.order.module.order.domain;

import com.smart.commerce.order.module.menu.Menu;

import java.util.List;

public record OrderRecord(int orderId, int userId, int storeId, List<Menu> menuIds) {
}
