package com.smart.commerce.order.module.order.application.port.out;

public interface StoreStatusPort {
    Boolean getStoreOpenStatus(Long storeId);
}
