package com.smart.commerce.ceo.modules.store.api;

import com.smart.commerce.ceo.modules.store.api.dto.StoreRegisterRequest;
import com.smart.commerce.ceo.modules.store.api.dto.StoreRegisterResponse;
import com.smart.commerce.ceo.modules.store.api.dto.StoreUpdateStatusRequest;
import com.smart.commerce.ceo.modules.store.api.dto.StoreUpdateStatusResponse;
import com.smart.commerce.ceo.modules.store.application.StoreRegisterUseCase;
import com.smart.commerce.ceo.modules.store.application.StoreUpdateStatusUseCase;
import com.smart.commerce.ceo.modules.store.domain.Store;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class StoreApi {

    private final StoreRegisterUseCase storeRegisterUseCase;
    private final StoreUpdateStatusUseCase storeUpdateStatusUseCase;

    public StoreApi(final StoreRegisterUseCase storeRegisterUseCase,
                    final StoreUpdateStatusUseCase storeUpdateStatusUseCase) {
        this.storeRegisterUseCase = storeRegisterUseCase;
        this.storeUpdateStatusUseCase = storeUpdateStatusUseCase;
    }

    @PostMapping("/store")
    public ResponseEntity<StoreRegisterResponse> register(
            final HttpSession httpSession,
            @RequestBody final StoreRegisterRequest request
    ) {
        final long ceoId = Long.valueOf(httpSession.getAttribute("ceo").toString());
        final Store store = storeRegisterUseCase.register(request.toCommand(ceoId));
        return ResponseEntity.created(URI.create("/store/" + store.getId()))
                .body(new StoreRegisterResponse(store.getId()));
    }

    @PostMapping("/store/status")
    public ResponseEntity<StoreUpdateStatusResponse> updateStatus(
            final HttpSession httpSession,
            @RequestBody final StoreUpdateStatusRequest request
    ) {
        final long ceoId = Long.valueOf(httpSession.getAttribute("ceo").toString());
        final Store store = storeUpdateStatusUseCase.updateStatus(request.toCommand(ceoId));
        return ResponseEntity.ok().body(new StoreUpdateStatusResponse(store.getId(), store.getStatus()));
    }
}
