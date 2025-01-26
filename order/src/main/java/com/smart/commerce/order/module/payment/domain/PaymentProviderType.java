package com.smart.commerce.order.module.payment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 결제 수단
 * - 사용자는 다음 중 하나의 결제 수단을 선택할 수 있다
 * - 머니 결제: 사용자 계정의 머니를 사용하고 결제
 *    - 머니가 부족할 경우 자동으로 충전하여 결제할 수 잇다
 *    - 충전 최소 금액은 머니팀에서 정의한 최소 충전 금액을 따라야 하며, 충전 실패 시 결제 실패가 된다
 * - PG사 결제: PG사를 연동하여 결제를 진행한다
 */

@Getter
@AllArgsConstructor
public enum PaymentProviderType {
    MONEY("페이 머니"),
    PG("PG사 결제"),
    ;

    private final String description;
}
