package com.smart.commerce.ceo.modules.store.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreEntityRepository extends JpaRepository<StoreEntity, Long> {
    Optional<StoreEntity> findByIdAndCeoId(Long id, Long ceoId);
}
