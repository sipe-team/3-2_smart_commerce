package com.smart.commerce.purchaseorder.modules.purchaseorder.infrastructure;

import com.smart.commerce.purchaseorder.modules.purchaseorder.domain.PurchaseOrderHistory;
import com.smart.commerce.purchaseorder.modules.purchaseorder.domain.PurchaseOrderHistoryRepository;
import com.smart.commerce.purchaseorder.modules.purchaseorder.infrastructure.mapper.PurchaseOrderHistoryDomainEntityMapper;
import com.smart.commerce.purchaseorder.modules.purchaseorder.infrastructure.persistence.PurchaseOrderHistoryEntityRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class PurchaseOrderHistoryRepositoryAdapter implements PurchaseOrderHistoryRepository {

    private final PurchaseOrderHistoryDomainEntityMapper purchaseOrderDomainEntityMapper;
    private final PurchaseOrderHistoryEntityRepository purchaseOrderHistoryEntityRepository;

    public PurchaseOrderHistoryRepositoryAdapter(PurchaseOrderHistoryDomainEntityMapper purchaseOrderDomainEntityMapper, PurchaseOrderHistoryEntityRepository purchaseOrderHistoryEntityRepository) {
        this.purchaseOrderDomainEntityMapper = purchaseOrderDomainEntityMapper;
        this.purchaseOrderHistoryEntityRepository = purchaseOrderHistoryEntityRepository;
    }

    @Override
    @Transactional
    public PurchaseOrderHistory save(final PurchaseOrderHistory purchaseOrderHistory) {
        return Optional.ofNullable(purchaseOrderDomainEntityMapper.toEntity(purchaseOrderHistory))
                .map(purchaseOrderHistoryEntityRepository::save)
                .map(purchaseOrderDomainEntityMapper::toDomain)
                .orElseThrow(RuntimeException::new);
    }

}
