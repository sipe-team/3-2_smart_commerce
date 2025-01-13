package com.smart.member.modules.auth.application.service;

import com.smart.member.modules.auth.application.SignInUseCase;
import com.smart.member.modules.auth.application.SignUpUseCase;
import com.smart.member.modules.auth.application.dto.SignInCommand;
import com.smart.member.modules.auth.application.dto.SignUpCommand;
import com.smart.member.modules.auth.domain.Authorization;
import com.smart.member.modules.auth.domain.AuthorizationRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements SignUpUseCase, SignInUseCase {

    private final PasswordEncoder passwordEncoder;
    private final AuthorizationRepository authorizationRepository;

    public AuthService(final PasswordEncoder passwordEncoder, final AuthorizationRepository authorizationRepository) {
        this.passwordEncoder = passwordEncoder;
        this.authorizationRepository = authorizationRepository;
    }

    @Override
    public Authorization signUp(final SignUpCommand command) {
        final String password = passwordEncoder.encode(command.password());
        return authorizationRepository.save(new Authorization(null, command.email(), password));
    }

    @Override
    public Authorization signIn(final SignInCommand command) {
        final Authorization authorization = authorizationRepository.findByEmail(command.email());
        authorization.signIn(command.password(), passwordEncoder::matches);
        return authorization;
    }
}
