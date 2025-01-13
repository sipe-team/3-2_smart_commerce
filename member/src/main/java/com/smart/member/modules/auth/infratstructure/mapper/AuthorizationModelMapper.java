package com.smart.member.modules.auth.infratstructure.mapper;

import com.smart.member.modules.auth.domain.Authorization;
import com.smart.member.modules.auth.infratstructure.persistence.AuthorizationEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationModelMapper implements AuthorizationMapper {

    private final ModelMapper modelMapper;

    public AuthorizationModelMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorizationEntity toEntity(final Authorization authorization) {
        return modelMapper.map(authorization, AuthorizationEntity.class);
    }

    @Override
    public Authorization toDomain(final AuthorizationEntity authorizationEntity) {
        return modelMapper.map(authorizationEntity, Authorization.class);
    }
}
