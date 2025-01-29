package com.smart.commerce.ceo.modules.menu.domain;

import java.util.Objects;

public class MenuGroupName {
    private final String value;

    public MenuGroupName(String value) {
        if(!isValid(value)) throw new IllegalArgumentException("유효하지 않은 메뉴 그룹 명입니다.");
        this.value = value;
    }

    private boolean isValid(String value) {
        if (value == null || value.trim().isEmpty()) return false;
        if (value.length() > 15) return false;
        if (!value.matches("[\\w ()\\[\\]+&/_]*")) return false;
        //TODO: purgoMalum 연동하기
        return true;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuGroupName that = (MenuGroupName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
