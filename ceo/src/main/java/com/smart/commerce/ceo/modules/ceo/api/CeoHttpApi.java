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
public class CeoHttpApi {

    private final CeoRegisterUseCase ceoRegisterUseCase;
    private final CeoLoginUseCase ceoLoginUseCase;

    public CeoHttpApi(final CeoRegisterUseCase ceoRegisterUseCase,
                      final CeoLoginUseCase ceoLoginUseCase) {
        this.ceoRegisterUseCase = ceoRegisterUseCase;
        this.ceoLoginUseCase = ceoLoginUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> register(
            @RequestBody CeoRegisterRequest request
    ) {
        ceoRegisterUseCase.register(request.toCommand());
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> login(
            HttpSession httpSession,
            @RequestBody CeoLoginRequest request
    ) {
        final Ceo ceo = ceoLoginUseCase.login(request.toCommand());
        session(httpSession, ceo);
        return ResponseEntity.ok().build();
    }

    private static void session(final HttpSession httpSession, final Ceo ceo) {
        httpSession.setAttribute("ceo_id", ceo.getId());
        httpSession.setMaxInactiveInterval(24 * 60 * 60);
    }
}
