package com.smart.commerce.ceo.modules.ceo.domain;

import java.util.Objects;

public class Cbo {
    private final Long id;
    private final String ceoName;
    private final String ceoBirth;
    private final String businessName;
    private final String businessAddress;
    private final String businessArea;
    private final String businessType;
    private final String condition;

    public static Cbo initialize(final String ceoName, final String ceoBirth,
                                 final String businessName, final String businessAddress, final String businessArea,
                                 final String businessType, final String condition) {
        return new Cbo(null, ceoName, ceoBirth, businessName, businessAddress, businessArea, businessType, condition);
    }

    public Cbo(final Long id, final String ceoName, final String ceoBirth,
               final String businessName, final String businessAddress, final String businessArea,
               final String businessType, final String condition) {
        this.id = id;
        this.ceoName = ceoName;
        this.ceoBirth = ceoBirth;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessArea = businessArea;
        this.businessType = businessType;
        this.condition = condition;
    }

    public Long getId() {
        return id;
    }

    public String getCeoName() {
        return ceoName;
    }

    public String getCeoBirth() {
        return ceoBirth;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public String getBusinessType() {
        return businessType;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Cbo cbo = (Cbo) o;
        return Objects.equals(getId(), cbo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
