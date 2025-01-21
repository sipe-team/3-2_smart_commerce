package com.smart.commerce.customer.modules.auth.domain;

public class Customer {

    private final Long id;
    private final String email;
    private final String password;

    public Customer(final Long id, final String email, final String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void signIn(final String rawPassword, final CustomerAuthorizePasswordService customerAuthorizePasswordService) {
        final boolean matches = customerAuthorizePasswordService.matches(rawPassword, password);
        if(!matches) {
            throw new IllegalArgumentException("Password not matched");
        }
    }
}
