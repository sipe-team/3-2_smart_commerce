package com.smart.commerce.customer.modules.auth.infratstructure.mapper;

import com.smart.commerce.customer.modules.auth.infratstructure.persistence.CustomerEntity;
import com.smart.commerce.customer.modules.auth.domain.Customer;

public interface CustomerDomainEntityMapper {
    CustomerEntity toEntity(final Customer customer);
    Customer toDomain(final CustomerEntity customerEntity);
}
