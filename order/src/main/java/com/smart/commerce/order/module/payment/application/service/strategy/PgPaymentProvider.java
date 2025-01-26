package com.smart.commerce.order.module.payment.application.service.strategy;

import com.smart.commerce.order.module.payment.application.dto.PayProviderCommand;
import com.smart.commerce.order.module.payment.application.dto.PayProviderResult;
import com.smart.commerce.order.module.payment.domain.PaymentProviderType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.smart.commerce.order.module.payment.domain.PaymentProviderType.PG;

@Slf4j
@Component
public class PgPaymentProvider implements PaymentProvider {

    @Override
    public boolean isSupport(PaymentProviderType providerType) {
        return PG.equals(providerType);
    }

    @Override
    public PayProviderResult pay(PayProviderCommand command) {
        log.info("PG 결제 완료 - {}", command);
        return new PayProviderResult(
                UUID.randomUUID().toString(),
                true
        );
    }
}
