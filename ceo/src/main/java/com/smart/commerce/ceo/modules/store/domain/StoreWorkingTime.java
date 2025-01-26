package com.smart.commerce.ceo.modules.store.domain;

import java.time.LocalDateTime;

public record StoreWorkingTime(
        LocalDateTime openTime,
        LocalDateTime closeTime
) {

    public boolean isOpenTime(final LocalDateTime localDateTime) {
        return localDateTime.isAfter(openTime) && localDateTime.isBefore(closeTime);
    }
}
