package com.smart.commerce.order.module.cart.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderLines {

    private final List<OrderLine> orderLines;

    public OrderLines() {
        this.orderLines = new ArrayList<>();
    }

    public void add(final Long menuId) {
        final Optional<OrderLine> orderLineOptional = getOrderLine(menuId);
        if (orderLineOptional.isPresent()) {
            final OrderLine orderLine = orderLineOptional.get();
            orderLine.add();
            return;
        }
        orderLines.add(new OrderLine(menuId));
    }

    public void clear() {
        orderLines.clear();
    }

    public void minus(final Long menuId) {
        final Optional<OrderLine> orderLineOptional = getOrderLine(menuId);
        if (orderLineOptional.isPresent()) {
            final OrderLine orderLine = orderLineOptional.get();
            try {
                orderLine.minus();
            } catch (IllegalArgumentException e) {
                orderLines.remove(orderLine);
            }
        }
    }

    public void remove(final Long menuId) {
        final Optional<OrderLine> orderLineOptional = getOrderLine(menuId);
        if (orderLineOptional.isPresent()) {
            final OrderLine orderLine = orderLineOptional.get();
            orderLines.remove(orderLine);
        }
    }

    private Optional<OrderLine> getOrderLine(final Long menuId) {
        return orderLines.stream()
                .filter(orderLine -> orderLine.isEqualsMenu(menuId))
                .findFirst();
    }

    public List<Long> getMenuIds() {
        return orderLines.stream()
                .map(OrderLine::getMenuId)
                .collect(Collectors.toList());
    }

    public Long getAmount(Map<Long, Menu> menus) {
        return orderLines.stream()
                .mapToLong(orderLine -> orderLine.getAmount(menus))
                .sum();
    }
}
