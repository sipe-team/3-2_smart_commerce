package com.smart.commerce.customer.modules.auth.infratstructure.mapper;

import com.smart.commerce.customer.modules.auth.domain.Customer;
import com.smart.commerce.customer.modules.auth.infratstructure.persistence.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerDomainEntityModelMapper implements CustomerDomainEntityMapper {

    private final ModelMapper modelMapper;

    public CustomerDomainEntityModelMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerEntity toEntity(final Customer customer) {
        return modelMapper.map(customer, CustomerEntity.class);
    }

    @Override
    public Customer toDomain(final CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, Customer.class);
    }
}
