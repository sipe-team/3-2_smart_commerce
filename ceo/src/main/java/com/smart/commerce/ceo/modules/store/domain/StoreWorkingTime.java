package com.smart.commerce.ceo.modules.store.domain;

import java.time.LocalTime;

public record StoreWorkingTime(
        LocalTime openTime,
        LocalTime closeTime
) {

    public boolean isOpenTime(final LocalTime localDateTime) {
        return localDateTime.isAfter(openTime) && localDateTime.isBefore(closeTime);
    }
}
