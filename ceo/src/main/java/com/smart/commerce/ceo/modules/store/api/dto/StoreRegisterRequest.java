package com.smart.commerce.ceo.modules.store.api.dto;

import com.smart.commerce.ceo.modules.store.application.dto.StoreRegisterCommand;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record StoreRegisterRequest(
        String name,
        String address,
        String category,
        String description,
        String callNumber,
        String convenienceInfo,
        String openTime,
        String closeTime
) {
    public StoreRegisterCommand toCommand(final long ceoId) {
        return new StoreRegisterCommand(
                ceoId,
                name,
                address,
                category,
                description,
                callNumber,
                convenienceInfo,
                LocalTime.parse(openTime),
                LocalTime.parse(closeTime)
        );
    }
}
