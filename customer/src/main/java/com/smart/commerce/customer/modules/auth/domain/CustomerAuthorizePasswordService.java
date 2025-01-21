package com.smart.commerce.customer.modules.auth.domain;

@FunctionalInterface
public interface CustomerAuthorizePasswordService {
    boolean matches(String rawPassword, String encodedPassword);
}
