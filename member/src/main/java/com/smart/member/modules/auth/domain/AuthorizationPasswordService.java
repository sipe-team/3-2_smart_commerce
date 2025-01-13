package com.smart.member.modules.auth.domain;

@FunctionalInterface
public interface AuthorizationPasswordService {
    boolean matches(String rawPassword, String encodedPassword);
}
