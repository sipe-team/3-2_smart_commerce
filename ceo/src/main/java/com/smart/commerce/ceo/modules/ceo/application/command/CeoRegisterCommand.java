package com.smart.commerce.ceo.modules.ceo.application.command;

public record CeoRegisterCommand(
        String account,
        String password,
        String name,
        String birth,
        String phoneNumber,
        String email
) {

}
