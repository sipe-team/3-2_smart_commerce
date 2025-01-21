package com.smart.commerce.ceo.modules.ceo.api.dto;

import com.smart.commerce.ceo.modules.ceo.application.command.CeoRegisterCboCommand;

public record CeoRegisterCboRequest(
        long ceoId,
        String ceoName,
        String ceoBirth,
        String businessName,
        String businessAddress,
        String businessArea,
        String businessType,
        String condition
) {
    public CeoRegisterCboCommand command(long ceoId) {
        return new CeoRegisterCboCommand(
                ceoId,
                ceoName,
                ceoBirth,
                businessName,
                businessAddress,
                businessArea,
                businessType,
                condition
        );
    }
}
