package com.smart.commerce.ceo.modules.ceo.api;

import com.smart.commerce.ceo.modules.ceo.api.dto.CeoRegisterCboRequest;
import com.smart.commerce.ceo.modules.ceo.api.dto.CeoRegisterCboResponse;
import com.smart.commerce.ceo.modules.ceo.api.dto.CeoRegisterCbrRequest;
import com.smart.commerce.ceo.modules.ceo.api.dto.CeoRegisterCbrResponse;
import com.smart.commerce.ceo.modules.ceo.application.usecase.CeoRegisterCboUseCase;
import com.smart.commerce.ceo.modules.ceo.application.usecase.CeoRegisterCbrUseCase;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/ceos")
@RestController
public class CeoCertificateApi {

    private final CeoRegisterCbrUseCase ceoRegisterCbrUseCase;
    private final CeoRegisterCboUseCase ceoRegisterCboUseCase;

    public CeoCertificateApi(final CeoRegisterCbrUseCase ceoRegisterCbrUseCase,
                             final CeoRegisterCboUseCase ceoRegisterCboUseCase) {
        this.ceoRegisterCbrUseCase = ceoRegisterCbrUseCase;
        this.ceoRegisterCboUseCase = ceoRegisterCboUseCase;
    }

    @PostMapping("/cbr")
    public ResponseEntity<CeoRegisterCbrResponse> cbr(
            final HttpSession httpSession,
            @RequestBody final CeoRegisterCbrRequest request
    ) {
        final long ceoId = Long.valueOf(httpSession.getAttribute("ceo").toString());
        ceoRegisterCbrUseCase.registerCbr(request.command(ceoId));
        return ResponseEntity.ok(new CeoRegisterCbrResponse());
    }

    @PostMapping("/cbo")
    public ResponseEntity<CeoRegisterCboResponse> cbo(
            final HttpSession httpSession,
            @RequestBody final CeoRegisterCboRequest request
    ) {
        final long ceoId = Long.valueOf(httpSession.getAttribute("ceo").toString());
        ceoRegisterCboUseCase.registerCbo(request.command(ceoId));
        return ResponseEntity.ok(new CeoRegisterCboResponse());
    }
}
