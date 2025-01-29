package com.smart.commerce.purchaseorder.modules.purchaseorder.infrastructure.mapper;

public interface DomainEntityMapper<DOMAIN, ENTITY> {
    ENTITY toEntity(DOMAIN domain);
    DOMAIN toDomain(ENTITY entity);
}