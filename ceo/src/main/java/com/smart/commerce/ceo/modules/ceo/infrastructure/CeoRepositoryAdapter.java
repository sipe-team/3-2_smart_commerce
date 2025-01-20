package com.smart.commerce.ceo.modules.ceo.infrastructure;

import com.smart.commerce.ceo.modules.ceo.domain.Ceo;
import com.smart.commerce.ceo.modules.ceo.domain.CeoRepository;
import com.smart.commerce.ceo.modules.ceo.infrastructure.mapper.CeoDomainEntityMapper;
import com.smart.commerce.ceo.modules.ceo.infrastructure.mapper.CeoDomainEntityMapperImpl;
import com.smart.commerce.ceo.modules.ceo.infrastructure.persistence.CeoEntityRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class CeoRepositoryAdapter implements CeoRepository {

    private final CeoDomainEntityMapper ceoDomainEntityMapper;
    private final CeoEntityRepository ceoEntityRepository;

    public CeoRepositoryAdapter(final CeoDomainEntityMapperImpl ceoDomainEntityMapper, final CeoEntityRepository ceoEntityRepository) {
        this.ceoDomainEntityMapper = ceoDomainEntityMapper;
        this.ceoEntityRepository = ceoEntityRepository;
    }

    @Override
    @Transactional
    public Ceo save(final Ceo ceo) {
        return Optional.ofNullable(ceoDomainEntityMapper.toEntity(ceo))
                .map(ceoEntityRepository::save)
                .map(ceoDomainEntityMapper::toDomain)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional(readOnly = true)
    public Ceo findByAccount(final String account) {
        return ceoEntityRepository.findByAccount(account)
                .map(ceoDomainEntityMapper::toDomain)
                .orElseThrow(RuntimeException::new);
    }
}
