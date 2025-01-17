package com.smart.commerce.customer.modules.auth.application.dto;

public record CustomerSignUpCommand(
        String email,
        String password
) {
}
