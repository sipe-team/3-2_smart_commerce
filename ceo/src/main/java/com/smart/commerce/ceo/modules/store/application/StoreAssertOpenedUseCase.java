package com.smart.commerce.ceo.modules.store.application;

import java.time.LocalTime;

@FunctionalInterface
public interface StoreAssertOpenedUseCase {
    boolean isOpened(final Long storeId, final LocalTime localDateTime);
}
