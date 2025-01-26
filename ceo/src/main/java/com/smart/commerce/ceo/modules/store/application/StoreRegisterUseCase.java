package com.smart.commerce.ceo.modules.store.application;

import com.smart.commerce.ceo.modules.store.application.dto.StoreRegisterCommand;
import com.smart.commerce.ceo.modules.store.domain.Store;

public interface StoreRegisterUseCase {
    Store register(StoreRegisterCommand command);
}
