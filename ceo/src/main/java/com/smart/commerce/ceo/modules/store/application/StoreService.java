package com.smart.commerce.ceo.modules.store.application;

import com.smart.commerce.ceo.modules.store.application.dto.StoreRegisterCommand;
import com.smart.commerce.ceo.modules.store.domain.Store;
import com.smart.commerce.ceo.modules.store.domain.StoreRepository;
import com.smart.commerce.ceo.modules.store.domain.StoreWorkingTime;
import org.springframework.stereotype.Service;

@Service
public class StoreService implements StoreRegisterUseCase {

    private final StoreRepository storeRepository;

    public StoreService(final StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store register(final StoreRegisterCommand command) {
        final Store store = Store.initialize(command.ceoId(), command.name(), command.address(),
                command.category(), command.description(), command.callNumber(), command.convenienceInfo(),
                command.status(), new StoreWorkingTime(command.openTime(), command.closeTime()));
        return storeRepository.save(store);
    }
}
