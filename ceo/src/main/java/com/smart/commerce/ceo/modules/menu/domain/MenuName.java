package com.smart.commerce.ceo.modules.menu.domain;

import java.util.Objects;

public class MenuName {
    private final String value;

    public MenuName(String value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException("유효하지 않은 메뉴명입니다.");
        }
        this.value = value;
    }

    private boolean isValid(String value) {
        if (value == null || value.trim().isEmpty()) return false;
        if (value.length() > 15) return false;
        if (value.matches("[\\w ()\\[\\]+&/_]*")) return false;
        //TODO: purgomalum 연동 필요
        return true;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuName menuName = (MenuName) o;
        return Objects.equals(value, menuName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
