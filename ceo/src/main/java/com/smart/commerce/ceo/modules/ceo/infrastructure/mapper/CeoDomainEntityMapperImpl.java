package com.smart.commerce.ceo.modules.ceo.infrastructure.mapper;

import com.smart.commerce.ceo.modules.ceo.domain.Cbo;
import com.smart.commerce.ceo.modules.ceo.domain.Cbr;
import com.smart.commerce.ceo.modules.ceo.domain.Ceo;
import com.smart.commerce.ceo.modules.ceo.infrastructure.persistence.CboEntity;
import com.smart.commerce.ceo.modules.ceo.infrastructure.persistence.CbrEntity;
import com.smart.commerce.ceo.modules.ceo.infrastructure.persistence.CeoEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
                ceo.getEmail(),
                toEntity(ceo.getCbr()),
                toEntity(ceo.getCbo())
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
                ceoEntity.getEmail(),
                toDomain(ceoEntity.getCbr()),
                toDomain(ceoEntity.getCbo())
        );
    }

    private CboEntity toEntity(final Cbo cbo) {
        return Optional.ofNullable(cbo)
                .map(it -> new CboEntity(
                        it.getId(),
                        it.getCeoName(),
                        it.getCeoBirth(),
                        it.getBusinessName(),
                        it.getBusinessAddress(),
                        it.getBusinessArea(),
                        it.getBusinessType(),
                        it.getCondition(),
                        null
                ))
                .orElse(null);
    }


    private Cbo toDomain(final CboEntity cboEntity) {
        return Optional.ofNullable(cboEntity)
                .map(it -> new Cbo(
                        it.getId(),
                        it.getCeoName(),
                        it.getCeoBirth(),
                        it.getBusinessName(),
                        it.getBusinessAddress(),
                        it.getBusinessArea(),
                        it.getBusinessType(),
                        it.getCondition()
                ))
                .orElse(null);
    }

    private CbrEntity toEntity(final Cbr cbr) {
        return Optional.ofNullable(cbr)
                .map(it -> new CbrEntity(
                        it.getId(),
                        it.getBrand(),
                        it.getCeoName(),
                        it.getBirthDate(),
                        it.getOpenDate(),
                        it.getBusinessAddress(),
                        it.getBusinessType(),
                        it.getIssueDate(),
                        null
                ))
                .orElse(null);
    }

    private Cbr toDomain(final CbrEntity entity) {
        return Optional.ofNullable(entity)
                .map(it -> new Cbr(
                        it.getId(),
                        it.getBrand(),
                        it.getCeoName(),
                        it.getBirthDate(),
                        it.getOpenDate(),
                        it.getBusinessAddress(),
                        it.getBusinessType(),
                        it.getIssueDate()
                ))
                .orElse(null);
    }
}
