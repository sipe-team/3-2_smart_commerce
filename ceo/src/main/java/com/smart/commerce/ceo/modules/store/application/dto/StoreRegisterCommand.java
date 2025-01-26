package com.smart.commerce.ceo.modules.store.application.dto;

import java.time.LocalTime;

public record StoreRegisterCommand(
        Long ceoId,
        String name,
        String address,
        String category,
        String description,
        String callNumber,
        String convenienceInfo,
        LocalTime openTime,
        LocalTime closeTime
) {
}
