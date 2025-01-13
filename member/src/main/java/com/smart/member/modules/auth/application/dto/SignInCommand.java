package com.smart.member.modules.auth.application.dto;

public record SignInCommand(
        String email,
        String password
) {

}
