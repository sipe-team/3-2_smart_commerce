package com.smart.commerce.ceo.modules.store.infrastructure.mapper;

import com.smart.commerce.ceo.modules.ceo.infrastructure.mapper.DomainEntityMapper;
import com.smart.commerce.ceo.modules.store.domain.Store;
import com.smart.commerce.ceo.modules.store.infrastructure.persistence.StoreEntity;
import org.springframework.stereotype.Component;

@Component
public class StoreDomainEntityMapper implements DomainEntityMapper<Store, StoreEntity> {
    @Override
    public StoreEntity toEntity(final Store store) {
        return new StoreEntity(
                store.getId(),
                store.getCeoId(),
                store.getName(),
                store.getAddress(),
                store.getCategory(),
                store.getDescription(),
                store.getCallNumber(),
                store.getConvenienceInfo(),
                store.getStatus(),
                store.getStoreWorkingTime().openTime(),
                store.getStoreWorkingTime().closeTime()
        );
    }

    @Override
    public Store toDomain(final StoreEntity storeEntity) {
        return null;
    }
}
