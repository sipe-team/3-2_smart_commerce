package com.smart.member.modules.auth.api.dto;

import com.smart.member.modules.auth.application.dto.SignUpCommand;

public record SignUpRequest(
        String email,
        String password
) {

    public SignUpCommand toCommand() {
        return new SignUpCommand(email, password);
    }
}
