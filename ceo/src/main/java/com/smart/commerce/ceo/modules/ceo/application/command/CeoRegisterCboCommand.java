package com.smart.commerce.ceo.modules.ceo.application.command;

public record CeoRegisterCboCommand(
        long ceoId,
        String ceoName,
        String ceoBirth,
        String businessName,
        String businessAddress,
        String businessArea,
        String businessType,
        String condition
) {
}
