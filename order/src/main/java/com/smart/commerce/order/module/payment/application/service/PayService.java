package com.smart.commerce.order.module.payment.application.service;

import com.smart.commerce.order.module.payment.application.dto.PayCommand;
import com.smart.commerce.order.module.payment.application.port.in.PayUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PayService implements PayUseCase {

    private final PaymentProviderFactory paymentProviderFactory;

    @Override
    public void pay(PayCommand command) {

    }
}
