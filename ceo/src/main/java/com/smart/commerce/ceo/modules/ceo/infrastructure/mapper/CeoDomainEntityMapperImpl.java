package com.smart.commerce.ceo.modules.ceo.infrastructure.mapper;

import com.smart.commerce.ceo.modules.ceo.domain.Ceo;
import com.smart.commerce.ceo.modules.ceo.infrastructure.persistence.CeoEntity;
import org.springframework.stereotype.Component;

@Component
public class CeoDomainEntityMapperImpl implements CeoDomainEntityMapper {

    @Override
    public CeoEntity toEntity(final Ceo ceo) {
        return new CeoEntity(
                ceo.getId(),
                ceo.getAccount(),
                ceo.getPassword(),
                ceo.getName(),
                ceo.getBirth(),
                ceo.getPhoneNumber(),
                ceo.getEmail()
        );
    }

    @Override
    public Ceo toDomain(final CeoEntity ceoEntity) {
        return new Ceo(
                ceoEntity.getId(),
                ceoEntity.getAccount(),
                ceoEntity.getPassword(),
                ceoEntity.getName(),
                ceoEntity.getBirth(),
                ceoEntity.getPhoneNumber(),
                ceoEntity.getEmail()
        );
    }
}
