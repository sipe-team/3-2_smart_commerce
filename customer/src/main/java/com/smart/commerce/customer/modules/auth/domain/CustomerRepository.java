package com.smart.commerce.customer.modules.auth.domain;

public interface CustomerRepository {
    Customer save(final Customer customer);

    Customer findByEmail(String email);
}
