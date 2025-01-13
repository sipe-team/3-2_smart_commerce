package com.smart.member.modules.auth.api.dto;

import com.smart.member.modules.auth.application.dto.SignInCommand;

public record SignInRequest(
        String email,
        String password
) {
    public SignInCommand toCommand() {
        return new SignInCommand(email, password);
    }
}
