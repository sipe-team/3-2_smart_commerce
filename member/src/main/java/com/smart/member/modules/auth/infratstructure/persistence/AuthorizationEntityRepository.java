package com.smart.member.modules.auth.infratstructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationEntityRepository extends JpaRepository<AuthorizationEntity, Long> {
    AuthorizationEntity findByEmail(String email);
}