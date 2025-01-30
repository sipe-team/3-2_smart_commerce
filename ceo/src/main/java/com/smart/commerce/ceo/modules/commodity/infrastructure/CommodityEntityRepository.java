package com.smart.commerce.ceo.modules.commodity.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommodityEntityRepository extends JpaRepository<CommodityEntity, Integer> {
    Optional<CommodityEntity> findById(UUID id);
    List<CommodityEntity> findAllByOrderByIdDesc();
    boolean existsById(UUID id);
}
