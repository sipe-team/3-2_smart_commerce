package com.smart.commerce.ceo.modules.store.application.dto;

public record StoreUpdateStatusCommand(
        Long ceoId,
        Long storeId,
        String status
) {
}
