package com.smart.member.modules.auth.infratstructure.mapper;

import com.smart.member.modules.auth.domain.Authorization;
import com.smart.member.modules.auth.infratstructure.persistence.AuthorizationEntity;

public interface AuthorizationMapper {
    AuthorizationEntity toEntity(final Authorization authorization);
    Authorization toDomain(final AuthorizationEntity authorizationEntity);
}
