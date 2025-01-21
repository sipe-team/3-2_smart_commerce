package com.smart.commerce.ceo.modules.ceo.application.command;

public record CeoLoginCommand(
        String account,
        String password
) {
}
