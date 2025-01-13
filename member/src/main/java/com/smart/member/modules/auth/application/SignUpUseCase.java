package com.smart.member.modules.auth.application;

import com.smart.member.modules.auth.application.dto.SignUpCommand;
import com.smart.member.modules.auth.domain.Authorization;

public interface SignUpUseCase {
    Authorization signUp(SignUpCommand command);
}
