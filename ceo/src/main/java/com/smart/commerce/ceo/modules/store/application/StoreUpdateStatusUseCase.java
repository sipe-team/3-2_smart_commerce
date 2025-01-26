package com.smart.commerce.ceo.modules.store.application;

import com.smart.commerce.ceo.modules.store.application.dto.StoreUpdateStatusCommand;
import com.smart.commerce.ceo.modules.store.domain.Store;

@FunctionalInterface
public interface StoreUpdateStatusUseCase {
    Store updateStatus(final StoreUpdateStatusCommand command);
}
