package com.smart.commerce.ceo.modules.ceo.api.dto;

import com.smart.commerce.ceo.modules.ceo.application.command.CeoRegisterCbrCommand;

public record CeoRegisterCbrRequest(
        String brand,
        String ceoName,
        String ceoBirth,
        String openDate,
        String businessAddress,
        String businessType,
        String issueDate
) {
    public CeoRegisterCbrCommand command(long ceoId) {
        return new CeoRegisterCbrCommand(
                ceoId,
                brand,
                ceoName,
                ceoBirth,
                openDate,
                businessAddress,
                businessType,
                issueDate
        );
    }
}
