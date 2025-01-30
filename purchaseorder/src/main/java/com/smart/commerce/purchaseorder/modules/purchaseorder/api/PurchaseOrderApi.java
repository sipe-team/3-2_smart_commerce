package com.smart.commerce.purchaseorder.modules.purchaseorder.api;

import com.smart.commerce.purchaseorder.modules.purchaseorder.api.dto.PurchaseOrderAcceptRequest;
import com.smart.commerce.purchaseorder.modules.purchaseorder.application.usecase.PurchaseOrderAcceptUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/purchase-order")
@RestController
public class PurchaseOrderApi {

    private final PurchaseOrderAcceptUseCase purchaseOrderAcceptUseCase;

    public PurchaseOrderApi(final PurchaseOrderAcceptUseCase purchaseOrderAcceptUseCase) {
        this.purchaseOrderAcceptUseCase = purchaseOrderAcceptUseCase;
    }

    @PostMapping("/{id}/accept")
    public ResponseEntity<Void> acceptOrder(
            @RequestBody final PurchaseOrderAcceptRequest request,
            @PathVariable String id) {
//        purchaseOrderAcceptUseCase.accept(request.toCommand());
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/{id}/reject")
//    public ResponseEntity<Void> rejectOrder(
//            final HttpSession httpSession,
//            @RequestBody final CeoLoginRequest request,
//            @PathVariable String id) {
//        final Ceo ceo = purchaseOrderAcceptUseCase.login(request.toCommand());
//        session(httpSession, ceo);
//        return ResponseEntity.ok().build();
//    }

}
