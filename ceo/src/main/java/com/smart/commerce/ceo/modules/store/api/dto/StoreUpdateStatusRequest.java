package com.smart.commerce.ceo.modules.store.api.dto;

import com.smart.commerce.ceo.modules.store.application.dto.StoreUpdateStatusCommand;

public record StoreUpdateStatusRequest(
        Long storeId,
        String status
) {
    public StoreUpdateStatusCommand toCommand(final long ceoId) {
        return new StoreUpdateStatusCommand(ceoId, storeId, status);
    }
}
