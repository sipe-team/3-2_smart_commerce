package com.smart.commerce.customer.modules.auth.api.dto;

import com.smart.commerce.customer.modules.auth.application.dto.CustomerSignInCommand;

public record CustomerSignInRequest(
        String email,
        String password
) {
    public CustomerSignInCommand toCommand() {
        return new CustomerSignInCommand(email, password);
    }
}
