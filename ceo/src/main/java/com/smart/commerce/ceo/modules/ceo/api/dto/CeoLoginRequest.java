package com.smart.commerce.ceo.modules.ceo.api.dto;

import com.smart.commerce.ceo.modules.ceo.application.command.CeoLoginCommand;

public record CeoLoginRequest(
        String account,
        String password
) {
    public CeoLoginCommand toCommand() {
        return new CeoLoginCommand(account, password);
    }
}
