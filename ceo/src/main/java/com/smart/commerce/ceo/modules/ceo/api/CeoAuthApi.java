package com.smart.commerce.ceo.modules.ceo.api;

import com.smart.commerce.ceo.modules.ceo.api.dto.CeoLoginRequest;
import com.smart.commerce.ceo.modules.ceo.api.dto.CeoRegisterRequest;
import com.smart.commerce.ceo.modules.ceo.application.usecase.CeoLoginUseCase;
import com.smart.commerce.ceo.modules.ceo.application.usecase.CeoRegisterUseCase;
import com.smart.commerce.ceo.modules.ceo.domain.Ceo;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/ceos")
@RestController
public class CeoAuthApi {

    private final CeoRegisterUseCase ceoRegisterUseCase;
    private final CeoLoginUseCase ceoLoginUseCase;

    public CeoAuthApi(final CeoRegisterUseCase ceoRegisterUseCase, final CeoLoginUseCase ceoLoginUseCase) {
        this.ceoRegisterUseCase = ceoRegisterUseCase;
        this.ceoLoginUseCase = ceoLoginUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> register(
            @RequestBody final CeoRegisterRequest request
    ) {
        ceoRegisterUseCase.register(request.toCommand());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(
            final HttpSession httpSession,
            @RequestBody final CeoLoginRequest request
    ) {
        final Ceo ceo = ceoLoginUseCase.login(request.toCommand());
        session(httpSession, ceo);
        return ResponseEntity.ok().build();
    }

    private void session(final HttpSession httpSession, final Ceo ceo) {
        httpSession.setAttribute("ceo", ceo.getId().toString());
        httpSession.setMaxInactiveInterval(24 * 60 * 60);
    }
}
