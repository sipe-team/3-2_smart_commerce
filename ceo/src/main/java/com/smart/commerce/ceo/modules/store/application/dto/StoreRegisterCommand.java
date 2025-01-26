package com.smart.commerce.ceo.modules.store.application.dto;

import java.time.LocalDateTime;

public record StoreRegisterCommand(
        Long ceoId,
        String name,
        String address,
        String category,
        String description,
        String callNumber,
        String convenienceInfo,
        String status,
        LocalDateTime openTime,
        LocalDateTime closeTime
) {
}
