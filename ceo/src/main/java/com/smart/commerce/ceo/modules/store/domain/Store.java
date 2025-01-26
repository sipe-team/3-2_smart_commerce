package com.smart.commerce.ceo.modules.store.domain;

import java.util.Objects;

public class Store {
    private final Long id;
    private final Long ceoId;
    private final String name;
    private final String address;
    private final String category;
    private final String description;
    private final String callNumber;
    private final String convenienceInfo;
    private final String status;
    private final StoreWorkingTime storeWorkingTime;

    public static Store initialize(final Long aLong, final String name, final String address, final String category, final String description, final String s, final String s1, final String status, final StoreWorkingTime storeWorkingTime) {
        return new Store(null, aLong, name, address, category, description, s, s1, status, storeWorkingTime);
    }

    public Store(final Long id, final Long ceoId,
                 final String name, final String address, final String category,
                 final String description, final String callNumber, final String convenienceInfo,
                 final String status, final StoreWorkingTime storeWorkingTime) {
        this.id = id;
        this.ceoId = ceoId;
        this.name = name;
        this.address = address;
        this.category = category;
        this.description = description;
        this.callNumber = callNumber;
        this.convenienceInfo = convenienceInfo;
        this.status = status;
        this.storeWorkingTime = storeWorkingTime;
    }

    public Long getId() {
        return id;
    }

    public Long getCeoId() {
        return ceoId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public String getConvenienceInfo() {
        return convenienceInfo;
    }

    public String getStatus() {
        return status;
    }

    public StoreWorkingTime getStoreWorkingTime() {
        return storeWorkingTime;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Store store = (Store) o;
        return Objects.equals(getId(), store.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
