package com.smart.commerce.customer.modules.commodity.domain;

import java.util.Objects;

public class CommodityPrice {
    private final Integer value;

    public CommodityPrice(int value) {
        if(!isValid(value)) throw new IllegalArgumentException("유효하지 않은 상품 가격입니다.");
        this.value = value;
    }

    private boolean isValid(int value) {
        return value >= 0 && value <= 1000000;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommodityPrice that = (CommodityPrice) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
