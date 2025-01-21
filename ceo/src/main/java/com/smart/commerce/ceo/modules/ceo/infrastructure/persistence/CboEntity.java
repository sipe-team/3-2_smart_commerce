package com.smart.commerce.ceo.modules.ceo.infrastructure.persistence;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.util.Objects;

@Table(name = "cbo")
@Entity
public class CboEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("대표자명")
    @Column(name = "ceo_name", nullable = false)
    private String ceoName;

    @Comment("대표자 생년월일")
    @Column(name = "ceo_birth", nullable = false)
    private String ceoBirth;

    @Comment("상호명")
    @Column(name = "business_name", nullable = false)
    private String businessName;

    @Comment("사업장 주소")
    @Column(name = "business_address", nullable = false)
    private String businessAddress;

    @Comment("사업장 면적")
    @Column(name = "business_area", nullable = false)
    private String businessArea;

    @Comment("업종")
    @Column(name = "business_type", nullable = false)
    private String businessType;

    @Comment("조건")
    @Column(name = "condition", nullable = false)
    private String condition;

    @JoinColumn(name = "ceo_id")
    @OneToOne
    private CeoEntity ceo;

    public CboEntity() {
    }

    public CboEntity(final Long id, final String ceoName, final String ceoBirth,
                     final String businessName, final String businessAddress, final String businessArea,
                     final String businessType, final String condition, final CeoEntity ceo) {
        this.id = id;
        this.ceoName = ceoName;
        this.ceoBirth = ceoBirth;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessArea = businessArea;
        this.businessType = businessType;
        this.condition = condition;
        this.ceo = ceo;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(final String ceoName) {
        this.ceoName = ceoName;
    }

    public String getCeoBirth() {
        return ceoBirth;
    }

    public void setCeoBirth(final String ceoBirth) {
        this.ceoBirth = ceoBirth;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(final String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(final String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(final String businessArea) {
        this.businessArea = businessArea;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(final String businessType) {
        this.businessType = businessType;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(final String condition) {
        this.condition = condition;
    }

    public CeoEntity getCeo() {
        return ceo;
    }

    public void setCeo(final CeoEntity ceo) {
        this.ceo = ceo;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CboEntity cboEntity = (CboEntity) o;
        return Objects.equals(getId(), cboEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
