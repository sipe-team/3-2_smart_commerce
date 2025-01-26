package com.smart.commerce.order.module.payment.infrastructure.persistence;

import org.jmolecules.ddd.annotation.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface OrderPaymentJpaRepository extends JpaRepository<OrderPaymentEntity, Long> {
    Optional<OrderPaymentEntity> findByOrderNumber(String orderNumber);
}
