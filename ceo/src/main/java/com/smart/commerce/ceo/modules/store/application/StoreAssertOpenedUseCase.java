package com.smart.commerce.ceo.modules.store.application;

import java.time.LocalDateTime;

@FunctionalInterface
public interface StoreAssertOpenedUseCase {
    boolean isOpened(final Long storeId, final LocalDateTime localDateTime);
}
