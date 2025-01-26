package com.smart.commerce.ceo.modules.store.infrastructure.mapper;

import com.smart.commerce.ceo.modules.ceo.infrastructure.mapper.DomainEntityMapper;
import com.smart.commerce.ceo.modules.store.domain.Store;
import com.smart.commerce.ceo.modules.store.domain.StoreStatus;
import com.smart.commerce.ceo.modules.store.domain.StoreWorkingTime;
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
        return new Store(
                storeEntity.getId(),
                storeEntity.getCeoId(),
                storeEntity.getName(),
                storeEntity.getAddress(),
                storeEntity.getCategory(),
                storeEntity.getDescription(),
                storeEntity.getCallNumber(),
                storeEntity.getConvenienceInfo(),
                StoreStatus.of(storeEntity.getStatus()),
                new StoreWorkingTime(storeEntity.getOpenTime(), storeEntity.getCloseTime())
        );
    }
}
