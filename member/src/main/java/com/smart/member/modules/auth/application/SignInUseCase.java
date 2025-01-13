package com.smart.member.modules.auth.application;

import com.smart.member.modules.auth.application.dto.SignInCommand;
import com.smart.member.modules.auth.domain.Authorization;

public interface SignInUseCase {
    Authorization signIn(SignInCommand command);
}
