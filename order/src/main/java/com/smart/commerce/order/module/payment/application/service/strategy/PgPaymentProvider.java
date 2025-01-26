package com.smart.commerce.order.module.payment.application.service.strategy;

import com.smart.commerce.order.module.payment.application.dto.PayCommand;
import com.smart.commerce.order.module.payment.application.dto.PayResult;
import com.smart.commerce.order.module.payment.domain.PaymentProviderType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.smart.commerce.order.module.payment.domain.PaymentProviderType.PG;

@Slf4j
@Component
public class PgPaymentProvider implements PaymentProvider {

    @Override
    public boolean isSupport(PaymentProviderType providerType) {
        return PG.equals(providerType);
    }

    @Override
    public PayResult pay(PayCommand command) {
        log.info("PG 결제 완료 - {}", command);
        return new PayResult();
    }
}
