package com.smart.commerce.customer.modules.auth.infratstructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByEmail(String email);
}