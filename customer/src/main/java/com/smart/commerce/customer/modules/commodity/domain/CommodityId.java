package com.smart.commerce.customer.modules.commodity.domain;

import java.util.Objects;
import java.util.UUID;

public class CommodityId {
    private final UUID value;

    public CommodityId(String value) {
        this.value = UUID.fromString(value);
    }

    public CommodityId(UUID value) {
        this.value = value;
    }

    public static CommodityId generate(){
        return new CommodityId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommodityId that = (CommodityId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
