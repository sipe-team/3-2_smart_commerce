package com.smart.commerce.ceo.modules.ceo.infrastructure.mapper;

public interface DomainEntityMapper<DOMAIN, ENTITY> {
    ENTITY toEntity(DOMAIN domain);
    DOMAIN toDomain(ENTITY entity);
}