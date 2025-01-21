package com.smart.commerce.ceo.modules.ceo.domain;

import java.util.Objects;
import java.util.function.Predicate;

public class Ceo {
    private final Long id;
    private final String account;
    private final String password;
    private final String name;
    private final String birth;
    private final String phoneNumber;
    private final String email;
    private final Cbr cbr;
    private final Cbo cbo;

    public static Ceo initialize(
            final String account,
            final String password,
            final String name,
            final String birth,
            final String phoneNumber,
            final String email
    ) {
        return new Ceo(
                null,
                account,
                password,
                name,
                birth,
                phoneNumber,
                email,
                null,
                null
        );
    }

    public Ceo(final Long id, final String account, final String password,
               final String name, final String birth, final String phoneNumber,
               final String email, final Cbr cbr, final Cbo cbo) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.cbr = cbr;
        this.cbo = cbo;
    }

    public void login(final Predicate<String> predicate) {
        final boolean matches = predicate.test(password);
        if(!matches) {
            throw new IllegalArgumentException("Password not matched");
        }
    }

    public Ceo registerCbr(final Cbr cbr) {
        return new Ceo(id, account, password, name, birth, phoneNumber, email, cbr, cbo);
    }


    public Ceo registerCbo(final Cbo cbo) {
        return new Ceo(id, account, password, name, birth, phoneNumber, email, cbr, cbo);
    }

    public Long getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Cbr getCbr() {
        return cbr;
    }

    public Cbo getCbo() {
        return cbo;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Ceo ceo = (Ceo) o;
        return Objects.equals(getId(), ceo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
