package com.smart.commerce.ceo.modules.ceo.infrastructure.persistence;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.util.Objects;

@Table(name = "ceo")
@Entity
public class CeoEntity {

    @Comment("고유번호")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("계정")
    @Column(name = "account", nullable = false, unique = true)
    private String account;

    @Comment("비밀번호")
    @Column(name = "password", nullable = false)
    private String password;

    @Comment("이름")
    @Column(name = "brand", nullable = false)
    private String name;

    @Comment("생년월일")
    @Column(name = "birth", nullable = false)
    private String birth;

    @Comment("휴대폰번호")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Comment("이메일")
    @Column(name = "email", nullable = false)
    private String email;

    @OneToOne(mappedBy = "ceo", cascade = CascadeType.ALL, orphanRemoval = true)
    private CbrEntity cbrEntity;

    @OneToOne(mappedBy = "ceo", cascade = CascadeType.ALL, orphanRemoval = true)
    private CboEntity cboEntity;

    public CeoEntity() {
    }

    public CeoEntity(final Long id, final String account, final String password,
                     final String name, final String birth, final String phoneNumber,
                     final String email, final CbrEntity cbrEntity, final CboEntity cboEntity) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.cbrEntity = cbrEntity;
        if (cbrEntity != null) {
            cbrEntity.setCeo(this);
        }
        this.cboEntity = cboEntity;
        if (cboEntity != null) {
            cboEntity.setCeo(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(final String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(final String birth) {
        this.birth = birth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public CbrEntity getCbr() {
        return cbrEntity;
    }

    public CboEntity getCbo() {
        return cboEntity;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CeoEntity ceoEntity = (CeoEntity) o;
        return Objects.equals(getId(), ceoEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
