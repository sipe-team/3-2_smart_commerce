package com.smart.commerce.order.module.order.infrastructure.repository.entity;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum OrderStatus {
    @JsonEnumDefaultValue PENDING_PAYMENT,
    CANCEL_PAYMENT,
    FAIL_PAYMENT,
}
