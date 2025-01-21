package com.smart.commerce.ceo.modules.ceo.application.command;

public record CeoRegisterCbrCommand(
        long ceoId,
        String brand,
        String ceoName,
        String birthDate,
        String openDate,
        String businessAddress,
        String businessType,
        String issueDate
) {
}
