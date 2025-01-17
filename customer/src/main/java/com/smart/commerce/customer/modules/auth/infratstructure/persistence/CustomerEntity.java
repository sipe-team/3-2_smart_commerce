package com.smart.commerce.customer.modules.auth.infratstructure.persistence;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.util.Objects;

@Table(name = "customer")
@Entity
public class CustomerEntity {

    @Comment("시퀀스")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("이메일")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Comment("비밀번호")
    @Column(name = "password", nullable = false)
    private String password;

    public CustomerEntity() {
    }

    public CustomerEntity(final Long id, final String email, final String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
