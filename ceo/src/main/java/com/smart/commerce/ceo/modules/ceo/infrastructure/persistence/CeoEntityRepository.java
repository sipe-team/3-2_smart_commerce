package com.smart.commerce.ceo.modules.ceo.infrastructure.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CeoEntityRepository extends JpaRepository<CeoEntity, Long> {
    Optional<CeoEntity> findByAccount(String account);
}
