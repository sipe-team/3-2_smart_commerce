package com.smart.commerce.ceo.modules.store.infrastructure;

import com.smart.commerce.ceo.modules.store.domain.Store;
import com.smart.commerce.ceo.modules.store.domain.StoreRepository;
import com.smart.commerce.ceo.modules.store.infrastructure.mapper.StoreDomainEntityMapper;
import com.smart.commerce.ceo.modules.store.infrastructure.persistence.StoreEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class StoreRepositoryAdapter implements StoreRepository {

    private final StoreDomainEntityMapper storeDomainEntityMapper;
    private final StoreEntityRepository storeEntityRepository;

    public StoreRepositoryAdapter(final StoreDomainEntityMapper storeDomainEntityMapper,
                                  final StoreEntityRepository storeEntityRepository) {
        this.storeDomainEntityMapper = storeDomainEntityMapper;
        this.storeEntityRepository = storeEntityRepository;
    }

    @Transactional
    @Override
    public Store save(final Store store) {
        return Optional.ofNullable(store)
                .map(storeDomainEntityMapper::toEntity)
                .map(storeEntityRepository::save)
                .map(storeDomainEntityMapper::toDomain)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Store findById(final Long storeId) {
        return storeEntityRepository.findById(storeId)
                .map(storeDomainEntityMapper::toDomain)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Store findByIdAndCeoId(final Long storeId, final Long ceoId) {
        return storeEntityRepository.findByIdAndCeoId(storeId, ceoId)
                .map(storeDomainEntityMapper::toDomain)
                .orElseThrow(EntityNotFoundException::new);
    }
}
