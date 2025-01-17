package com.smart.commerce.customer.modules.auth.infratstructure.mapper;

import com.smart.commerce.customer.modules.auth.infratstructure.persistence.CustomerEntity;
import com.smart.commerce.customer.modules.auth.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDomainEntityMapperImpl implements CustomerDomainEntityMapper {

    @Override
    public CustomerEntity toEntity(final Customer customer) {
        return new CustomerEntity(
                customer.getId(),
                customer.getEmail(),
                customer.getPassword()
        );
    }

    @Override
    public Customer toDomain(final CustomerEntity customerEntity) {
        return new Customer(
                customerEntity.getId(),
                customerEntity.getEmail(),
                customerEntity.getPassword()
        );
    }
}
