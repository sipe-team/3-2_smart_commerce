package com.smart.commerce.order.module.payment.presentation.controller;

import com.smart.commerce.order.module.payment.application.dto.PayCommand;
import com.smart.commerce.order.module.payment.application.port.out.GetOrderPort;
import com.smart.commerce.order.module.payment.application.port.in.PayUseCase;
import com.smart.commerce.order.module.payment.presentation.dto.PayRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/payment")
@RestController
public class PaymentController {

//    private final PayUseCase payUseCase;
//    private final GetOrderPort getOrderPort;
//
//    public PaymentController(PayUseCase payUseCase, GetOrderPort getOrderPort) {
//        this.payUseCase = payUseCase;
//        this.getOrderPort = getOrderPort;
//    }
//
//    @PostMapping
//    public ResponseEntity<Void> pay(
//            @RequestBody PayRequest request
//    ) {
//        var order = getOrderPort.getOrder(request.orderNumber());
//
//        payUseCase.pay(
//                new PayCommand(
//                    order.orderNumber(),
//                    request.providerType(),
//                    order.totalOrderAmount(),
//                    order.totalPayedAmount()
//                )
//        );
//
//        return ResponseEntity.ok().build();
//    }
}
