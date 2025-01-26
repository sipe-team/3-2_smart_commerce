package com.smart.commerce.ceo.modules.store.infrastructure.persistence;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "store")
@Entity
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("사장님 식별키")
    @Column(name = "ceo_id", nullable = false)
    private Long ceoId;

    @Comment("가게 이름")
    @Column(name = "name", nullable = false)
    private String name;

    @Comment("가게 주소")
    @Column(name = "address", nullable = false)
    private String address;

    @Comment("가게 카테고리")
    @Column(name = "category", nullable = false)
    private String category;

    @Comment("가게 설명")
    @Column(name = "description", nullable = false)
    private String description;

    @Comment("가게 전화번호")
    @Column(name = "call_number", nullable = false)
    private String callNumber;

    @Comment("가게 편의정보")
    @Column(name = "convenience_info", nullable = false)
    private String convenienceInfo;

    @Comment("가게 상태")
    @Column(name = "status", nullable = false)
    private String status;

    @Comment("가게 오픈시간")
    @Column(name = "open_time", nullable = false)
    private LocalDateTime openTime;

    @Comment("가게 마감시간")
    @Column(name = "close_time", nullable = false)
    private LocalDateTime closeTime;

    public StoreEntity() {
    }

    public StoreEntity(final Long id, final Long ceoId, final String name,
                       final String address, final String category, final String description,
                       final String callNumber, final String convenienceInfo, final String status,
                       final LocalDateTime openTime, final LocalDateTime closeTime) {
        this.id = id;
        this.ceoId = ceoId;
        this.name = name;
        this.address = address;
        this.category = category;
        this.description = description;
        this.callNumber = callNumber;
        this.convenienceInfo = convenienceInfo;
        this.status = status;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getCeoId() {
        return ceoId;
    }

    public void setCeoId(final Long ceoId) {
        this.ceoId = ceoId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(final String callNumber) {
        this.callNumber = callNumber;
    }

    public String getConvenienceInfo() {
        return convenienceInfo;
    }

    public void setConvenienceInfo(final String convenienceInfo) {
        this.convenienceInfo = convenienceInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public LocalDateTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(final LocalDateTime openTime) {
        this.openTime = openTime;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(final LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final StoreEntity that = (StoreEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
