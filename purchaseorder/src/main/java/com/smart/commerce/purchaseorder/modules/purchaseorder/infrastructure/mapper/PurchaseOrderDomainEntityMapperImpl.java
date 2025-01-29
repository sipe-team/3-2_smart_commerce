package com.smart.commerce.purchaseorder.modules.purchaseorder.infrastructure.mapper;

import com.smart.commerce.purchaseorder.modules.purchaseorder.domain.PurchaseOrder;
import com.smart.commerce.purchaseorder.modules.purchaseorder.infrastructure.persistence.PurchaseOrderEntity;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderDomainEntityMapperImpl implements PurchaseOrderDomainEntityMapper {

    @Override
    public PurchaseOrderEntity toEntity(final PurchaseOrder purchaseOrder) {
        return new PurchaseOrderEntity(
                purchaseOrder.getUserId(),
                purchaseOrder.getStoreId(),
                purchaseOrder.getStatus(),
                purchaseOrder.getCreatedAt(),
                purchaseOrder.getCreatedId(),
                purchaseOrder.getUpdatedAt(),
                purchaseOrder.getUpdatedId()
        );
    }

    @Override
    public PurchaseOrder toDomain(final PurchaseOrderEntity purchaseOrderEntity) {
        return new PurchaseOrder(
                purchaseOrderEntity.getId(),
                purchaseOrderEntity.getUserId(),
                purchaseOrderEntity.getStoreId(),
                purchaseOrderEntity.getStatus(),
                purchaseOrderEntity.getCreatedAt(),
                purchaseOrderEntity.getCreatedId(),
                purchaseOrderEntity.getUpdatedAt(),
                purchaseOrderEntity.getUpdatedId()
        );
    }

}
