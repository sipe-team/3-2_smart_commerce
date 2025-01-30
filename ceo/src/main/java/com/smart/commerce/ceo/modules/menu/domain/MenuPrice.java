package com.smart.commerce.ceo.modules.menu.domain;

import java.util.Objects;

public class MenuPrice {
    private final Integer value;

    public MenuPrice(Integer value) {
        if(!isValid(value)) throw new IllegalArgumentException("유효하지 않은 메뉴 가격입니다.");
        this.value = value;
    }

    private boolean isValid(Integer value) {
        return value >= 0 && value <= 1000000;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuPrice menuPrice = (MenuPrice) o;
        return Objects.equals(value, menuPrice.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
