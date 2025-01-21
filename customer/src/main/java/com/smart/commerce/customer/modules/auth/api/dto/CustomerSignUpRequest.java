package com.smart.commerce.customer.modules.auth.api.dto;

import com.smart.commerce.customer.modules.auth.application.dto.CustomerSignUpCommand;

public record CustomerSignUpRequest(
        String email,
        String password
) {

    public CustomerSignUpCommand toCommand() {
        return new CustomerSignUpCommand(email, password);
    }
}
