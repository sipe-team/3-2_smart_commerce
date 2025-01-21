package com.smart.commerce.customer.modules.auth.application.dto;

public record CustomerSignInCommand(
        String email,
        String password
) {

}
