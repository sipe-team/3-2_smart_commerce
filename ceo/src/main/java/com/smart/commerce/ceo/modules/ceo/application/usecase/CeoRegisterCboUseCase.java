package com.smart.commerce.ceo.modules.ceo.application.usecase;

import com.smart.commerce.ceo.modules.ceo.application.command.CeoRegisterCboCommand;
import com.smart.commerce.ceo.modules.ceo.application.command.CeoRegisterCbrCommand;
import com.smart.commerce.ceo.modules.ceo.domain.Ceo;

public interface CeoRegisterCboUseCase {
    Ceo registerCbo(final CeoRegisterCboCommand command);
}
