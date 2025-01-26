package com.smart.commerce.ceo.modules.store.api;

import com.smart.commerce.ceo.modules.store.api.dto.*;
import com.smart.commerce.ceo.modules.store.application.StoreAssertOpenedUseCase;
import com.smart.commerce.ceo.modules.store.application.StoreRegisterUseCase;
import com.smart.commerce.ceo.modules.store.application.StoreUpdateStatusUseCase;
import com.smart.commerce.ceo.modules.store.domain.Store;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalTime;

@RestController
public class StoreApi {

    private final StoreRegisterUseCase storeRegisterUseCase;
    private final StoreUpdateStatusUseCase storeUpdateStatusUseCase;
    private final StoreAssertOpenedUseCase storeAssertOpenedUseCase;

    public StoreApi(final StoreRegisterUseCase storeRegisterUseCase,
                    final StoreUpdateStatusUseCase storeUpdateStatusUseCase,
                    final StoreAssertOpenedUseCase storeAssertOpenedUseCase) {
        this.storeRegisterUseCase = storeRegisterUseCase;
        this.storeUpdateStatusUseCase = storeUpdateStatusUseCase;
        this.storeAssertOpenedUseCase = storeAssertOpenedUseCase;
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

    @GetMapping("/store/status")
    public ResponseEntity<StoreAssertStatusResponse> isOpened(
            @RequestParam(value = "storeId") Long storeId
    ) {
        final LocalTime now = LocalTime.now();
        final boolean isOpened = storeAssertOpenedUseCase.isOpened(storeId, now);
        return ResponseEntity.ok().body(new StoreAssertStatusResponse(isOpened));
    }
}
