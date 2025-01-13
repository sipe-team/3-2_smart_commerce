package com.smart.member.modules.auth.infratstructure;

import com.smart.member.modules.auth.domain.Authorization;
import com.smart.member.modules.auth.domain.AuthorizationRepository;
import com.smart.member.modules.auth.infratstructure.mapper.AuthorizationMapper;
import com.smart.member.modules.auth.infratstructure.persistence.AuthorizationEntity;
import com.smart.member.modules.auth.infratstructure.persistence.AuthorizationEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AuthorizationRepositoryAdapter implements AuthorizationRepository {

    private final AuthorizationMapper authorizationMapper;
    private final AuthorizationEntityRepository authorizationEntityRepository;

    public AuthorizationRepositoryAdapter(
            @Qualifier("authorizationMapperImpl") final AuthorizationMapper authorizationMapper,
            final AuthorizationEntityRepository authorizationEntityRepository) {
        this.authorizationMapper = authorizationMapper;
        this.authorizationEntityRepository = authorizationEntityRepository;
    }

    @Transactional
    public Authorization save(final Authorization authorization) {
        final AuthorizationEntity authorizationEntity = authorizationMapper.toEntity(authorization);
        return Optional.of(authorizationEntityRepository.save(authorizationEntity))
                .map(authorizationMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Failed to save authorization"));
    }

    @Override
    public Authorization findByEmail(final String email) {
        return Optional.of(authorizationEntityRepository.findByEmail(email))
                .map(authorizationMapper::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("Authorization not found"));
    }
}
