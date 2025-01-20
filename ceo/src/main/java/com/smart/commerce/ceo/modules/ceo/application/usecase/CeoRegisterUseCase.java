package com.smart.commerce.ceo.modules.ceo.application.usecase;

import com.smart.commerce.ceo.modules.ceo.application.command.CeoRegisterCommand;
import com.smart.commerce.ceo.modules.ceo.domain.Ceo;

public interface CeoRegisterUseCase {
    Ceo register(CeoRegisterCommand command);
}
