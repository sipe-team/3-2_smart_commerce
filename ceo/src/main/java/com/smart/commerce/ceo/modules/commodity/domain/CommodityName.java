package com.smart.commerce.ceo.modules.commodity.domain;

import java.util.Objects;

public class CommodityName {
    private final String value;

    public CommodityName(String value) {
        if(!isValid(value)) throw new IllegalArgumentException("유효하지 않은 상품명입니다. ");
        this.value = value;
    }

    private boolean isValid(String value) {
        if(value == null) return false;
        if(value.length() > 15) return false;
        if(!value.matches("[\\w ()\\[\\]+&/_]")) return false;
        if(containsSwearword(value)) return false;
        return true;
    }

    private boolean containsSwearword(String value) {
        //TODO: purgoMalum 넣기
        return false;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommodityName that = (CommodityName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
