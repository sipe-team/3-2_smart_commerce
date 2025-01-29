package com.smart.commerce.purchaseorder.modules.purchaseorder.infrastructure;

import com.smart.commerce.purchaseorder.modules.purchaseorder.domain.PurchaseOrder;
import com.smart.commerce.purchaseorder.modules.purchaseorder.domain.PurchaseOrderRepository;
import com.smart.commerce.purchaseorder.modules.purchaseorder.infrastructure.mapper.PurchaseOrderDomainEntityMapper;
import com.smart.commerce.purchaseorder.modules.purchaseorder.infrastructure.persistence.PurchaseOrderEntityRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class PurchaseOrderRepositoryAdapter implements PurchaseOrderRepository {

    private final PurchaseOrderDomainEntityMapper purchaseOrderDomainEntityMapper;
    private final PurchaseOrderEntityRepository purchaseOrderEntityRepository;

    public PurchaseOrderRepositoryAdapter(PurchaseOrderDomainEntityMapper purchaseOrderDomainEntityMapper, PurchaseOrderEntityRepository purchaseOrderEntityRepository) {
        this.purchaseOrderDomainEntityMapper = purchaseOrderDomainEntityMapper;
        this.purchaseOrderEntityRepository = purchaseOrderEntityRepository;
    }

    @Override
    @Transactional
    public PurchaseOrder save(final PurchaseOrder purchaseOrder) {
        return Optional.ofNullable(purchaseOrderDomainEntityMapper.toEntity(purchaseOrder))
                .map(purchaseOrderEntityRepository::save)
                .map(purchaseOrderDomainEntityMapper::toDomain)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public PurchaseOrder updateStatus(final PurchaseOrder purchaseOrder) {
        return purchaseOrderEntityRepository.findById(purchaseOrder.getId())
                .map(purchaseOrderEntity -> {
                    if (!purchaseOrderEntity.getStatus().equals(purchaseOrder.getStatus())) {
                        purchaseOrderEntity.updateStatus(purchaseOrder.getStatus());
                        purchaseOrderEntity.updateUpdatedId(purchaseOrder.getUpdatedId());
                        purchaseOrderEntity.updateUpdatedAt(purchaseOrder.getUpdatedAt());
                    }
                    return purchaseOrderEntity;
                })
                .map(purchaseOrderEntityRepository::save)
                .map(purchaseOrderDomainEntityMapper::toDomain)
                .orElseThrow(RuntimeException::new);
    }

//    @Override
//    @Transactional(readOnly = true)
//    public Ceo findByAccount(final String account) {
//        return purchaseOrderEntityRepository.findByAccount(account)
//                .map(purchaseOrderDomainEntityMapper::toDomain)
//                .orElseThrow(RuntimeException::new);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Ceo findById(final long ceoId) {
//        return purchaseOrderEntityRepository.findById(ceoId)
//                .map(purchaseOrderDomainEntityMapper::toDomain)
//                .orElseThrow(RuntimeException::new);
//    }

}
