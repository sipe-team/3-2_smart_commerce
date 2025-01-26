package com.smart.commerce.ceo.modules.store.application;

import com.smart.commerce.ceo.modules.store.application.dto.StoreRegisterCommand;
import com.smart.commerce.ceo.modules.store.application.dto.StoreUpdateStatusCommand;
import com.smart.commerce.ceo.modules.store.domain.Store;
import com.smart.commerce.ceo.modules.store.domain.StoreRepository;
import com.smart.commerce.ceo.modules.store.domain.StoreWorkingTime;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class StoreService implements StoreRegisterUseCase, StoreUpdateStatusUseCase, StoreAssertOpenedUseCase {

    private final StoreRepository storeRepository;

    public StoreService(final StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store register(final StoreRegisterCommand command) {
        final Store store = Store.initialize(command.ceoId(), command.name(), command.address(),
                command.category(), command.description(), command.callNumber(), command.convenienceInfo(), new StoreWorkingTime(command.openTime(), command.closeTime()));
        return storeRepository.save(store);
    }

    @Override
    public Store updateStatus(final StoreUpdateStatusCommand command) {
        final Store store = storeRepository.findByIdAndCeoId(command.storeId(), command.ceoId());
        store.updateStatus(command.status());
        return storeRepository.save(store);
    }

    @Override
    public boolean isOpened(final Long storeId, final LocalTime localDateTime) {
        return storeRepository.findById(storeId)
                .isStoreOpened(localDateTime);
    }
}
