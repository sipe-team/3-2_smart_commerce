package com.smart.commerce.ceo.modules.menu.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MenuEntityRepository extends JpaRepository<MenuEntity, UUID> {
    Optional<MenuEntity> findById(UUID id);
    List<MenuEntity> findByStoreId(Long storeId);
}
