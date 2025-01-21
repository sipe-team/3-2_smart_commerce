package com.smart.commerce.ceo.modules.ceo.infrastructure.persistence;

import jakarta.persistence.*;

import java.util.Objects;

@Table(name = "cbr")
@Entity
public class CbrEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "ceo_name", nullable = false)
    private String ceoName;

    @Column(name = "birth_date", nullable = false)
    private String birthDate;

    @Column(name = "open_date", nullable = false)
    private String openDate;

    @Column(name = "business_address", nullable = false)
    private String businessAddress;

    @Column(name = "business_type", nullable = false)
    private String businessType;

    @Column(name = "issue_date", nullable = false)
    private String issueDate;

    @JoinColumn(name = "ceo_id")
    @OneToOne
    private CeoEntity ceo;

    public CbrEntity(final Long id, final String brand, final String ceoName, final String birthDate,
                     final String openDate, final String businessAddress, final String businessType,
                     final String issueDate, final CeoEntity ceo) {
        this.id = id;
        this.brand = brand;
        this.ceoName = ceoName;
        this.birthDate = birthDate;
        this.openDate = openDate;
        this.businessAddress = businessAddress;
        this.businessType = businessType;
        this.issueDate = issueDate;
        this.ceo = ceo;
    }

    public CbrEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public CeoEntity getCeo() {
        return ceo;
    }

    public void setCeo(final CeoEntity ceo) {
        this.ceo = ceo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(final String brand) {
        this.brand = brand;
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(final String ceoName) {
        this.ceoName = ceoName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final String birthDate) {
        this.birthDate = birthDate;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(final String openDate) {
        this.openDate = openDate;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(final String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(final String businessType) {
        this.businessType = businessType;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(final String issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CbrEntity cbrEntity = (CbrEntity) o;
        return Objects.equals(getId(), cbrEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
