package com.smart.member.modules.auth.infratstructure.mapper;

import com.smart.member.modules.auth.domain.Authorization;
import com.smart.member.modules.auth.infratstructure.persistence.AuthorizationEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationMapperImpl implements AuthorizationMapper {

    @Override
    public AuthorizationEntity toEntity(final Authorization authorization) {
        return new AuthorizationEntity(
                authorization.getId(),
                authorization.getEmail(),
                authorization.getPassword()
        );
    }

    @Override
    public Authorization toDomain(final AuthorizationEntity authorizationEntity) {
        return new Authorization(
                authorizationEntity.getId(),
                authorizationEntity.getEmail(),
                authorizationEntity.getPassword()
        );
    }
}
