package com.smart.commerce.ceo.modules.ceo.api.dto;

import com.smart.commerce.ceo.modules.ceo.application.command.CeoRegisterCommand;

public record CeoRegisterRequest(
        String account,
        String password,
        String name,
        String birth,
        String phoneNumber,
        String email
) {
    public CeoRegisterCommand toCommand() {
        return new CeoRegisterCommand(account, password, name, birth, phoneNumber, email);
    }
}
