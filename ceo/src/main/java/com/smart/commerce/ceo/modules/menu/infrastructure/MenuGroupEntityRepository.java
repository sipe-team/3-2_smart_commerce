package com.smart.commerce.ceo.modules.menu.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MenuGroupEntityRepository extends JpaRepository<MenuGroupEntity, UUID> {
    Optional<MenuGroupEntity> findById(UUID id);
}
