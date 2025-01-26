package com.smart.commerce.ceo.modules.store.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreEntityRepository extends JpaRepository<StoreEntity, Long> {
}
