package com.smart.commerce.ceo.modules.store.domain;

import java.util.Arrays;

public enum StoreStatus {
    OPEN("영업중"),
    CLOSE("휴업"),
    CLOSE_PERMANENTLY("폐업");

    private final String status;

    public static StoreStatus of(final String status) {
        return Arrays.stream(values())
                .filter(it -> it.name().equalsIgnoreCase(status))
                .findFirst()
                .orElseGet(() -> CLOSE);
    }

    StoreStatus(final String status) {
        this.status = status;
    }

    public String status() {
        return status;
    }
}
