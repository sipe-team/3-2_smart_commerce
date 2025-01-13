package com.smart.member.modules.auth.api;

import com.smart.member.modules.auth.api.dto.SignInRequest;
import com.smart.member.modules.auth.api.dto.SignInResponse;
import com.smart.member.modules.auth.api.dto.SignUpRequest;
import com.smart.member.modules.auth.api.dto.SignUpResponse;
import com.smart.member.modules.auth.application.SignInUseCase;
import com.smart.member.modules.auth.application.SignTokenCreateUseCase;
import com.smart.member.modules.auth.application.SignUpUseCase;
import com.smart.member.modules.auth.domain.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequestMapping("/auth")
@RestController
public class AuthApi {

    private final SignUpUseCase signUpUseCase;
    private final SignInUseCase signInUseCase;
    private final SignTokenCreateUseCase signTokenCreateUseCase;

    public AuthApi(final SignUpUseCase signUpUseCase,
                   final SignInUseCase signInUseCase,
                   final SignTokenCreateUseCase signTokenCreateUseCase) {
        this.signUpUseCase = signUpUseCase;
        this.signInUseCase = signInUseCase;
        this.signTokenCreateUseCase = signTokenCreateUseCase;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<SignUpResponse> signUp(
            @RequestBody final SignUpRequest request
    ) {
        signUpUseCase.signUp(request.toCommand());
        return ResponseEntity.created(URI.create("/auth/sign-in")).body(new SignUpResponse("ok"));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<SignInResponse> signIn(
            @RequestBody final SignInRequest request
    ) {
        final Authorization authorization = signInUseCase.signIn(request.toCommand());
        final String accessToken = signTokenCreateUseCase.create(authorization.getId());
        return ResponseEntity.ok().body(new SignInResponse(accessToken));
    }
}
