package com.smart.commerce.ceo.modules.ceo.domain;

import java.util.Objects;

public class Cbr {

    private final Long id;
    private final String brand;
    private final String ceoName;
    private final String birthDate;
    private final String openDate;
    private final String businessAddress;
    private final String businessType;
    private final String issueDate;

    public static Cbr initialize(final String brand, final String ceoName,
                         final String birthDate, final String openDate, final String businessAddress,
                         final String businessType, final String issueDate) {
        return new Cbr(null, brand, ceoName, birthDate, openDate, businessAddress, businessType, issueDate);
    }

    public Cbr(final Long id, final String brand, final String ceoName,
               final String birthDate, final String openDate, final String businessAddress,
               final String businessType, final String issueDate) {
        this.id = id;
        this.brand = brand;
        this.ceoName = ceoName;
        this.birthDate = birthDate;
        this.openDate = openDate;
        this.businessAddress = businessAddress;
        this.businessType = businessType;
        this.issueDate = issueDate;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getCeoName() {
        return ceoName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getOpenDate() {
        return openDate;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public String getBusinessType() {
        return businessType;
    }

    public String getIssueDate() {
        return issueDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Cbr cbr = (Cbr) o;
        return Objects.equals(getId(), cbr.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
