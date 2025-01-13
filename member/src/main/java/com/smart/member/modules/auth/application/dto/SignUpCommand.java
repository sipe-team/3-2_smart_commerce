package com.smart.member.modules.auth.application.dto;

public record SignUpCommand(
        String email,
        String password
) {
}
