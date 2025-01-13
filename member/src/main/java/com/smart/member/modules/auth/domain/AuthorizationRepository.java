package com.smart.member.modules.auth.domain;

public interface AuthorizationRepository {
    Authorization save(final Authorization authorization);

    Authorization findByEmail(String email);
}
