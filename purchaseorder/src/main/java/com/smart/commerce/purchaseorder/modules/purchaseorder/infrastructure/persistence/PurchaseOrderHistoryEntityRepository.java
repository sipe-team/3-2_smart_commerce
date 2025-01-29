package com.smart.commerce.purchaseorder.modules.purchaseorder.infrastructure.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PurchaseOrderHistoryEntityRepository extends JpaRepository<PurchaseOrderHistoryEntity, Long> {

}
