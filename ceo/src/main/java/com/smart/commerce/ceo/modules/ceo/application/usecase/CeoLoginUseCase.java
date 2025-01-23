package com.smart.commerce.ceo.modules.ceo.application.usecase;

import com.smart.commerce.ceo.modules.ceo.application.command.CeoLoginCommand;
import com.smart.commerce.ceo.modules.ceo.domain.Ceo;

public interface CeoLoginUseCase {
    Ceo login(final CeoLoginCommand command);
}
