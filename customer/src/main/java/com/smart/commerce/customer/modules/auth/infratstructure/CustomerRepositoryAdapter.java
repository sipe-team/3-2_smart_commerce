package com.smart.commerce.customer.modules.auth.infratstructure;

import com.smart.commerce.customer.modules.auth.domain.Customer;
import com.smart.commerce.customer.modules.auth.domain.CustomerRepository;
import com.smart.commerce.customer.modules.auth.infratstructure.mapper.CustomerDomainEntityMapper;
import com.smart.commerce.customer.modules.auth.infratstructure.persistence.CustomerEntity;
import com.smart.commerce.customer.modules.auth.infratstructure.persistence.CustomerEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerRepositoryAdapter implements CustomerRepository {

    private final CustomerDomainEntityMapper customerDomainEntityMapper;
    private final CustomerEntityRepository customerEntityRepository;

    public CustomerRepositoryAdapter(
            @Qualifier("customerDomainEntityMapperImpl") final CustomerDomainEntityMapper customerDomainEntityMapper,
            final CustomerEntityRepository customerEntityRepository) {
        this.customerDomainEntityMapper = customerDomainEntityMapper;
        this.customerEntityRepository = customerEntityRepository;
    }

    @Transactional
    public Customer save(final Customer customer) {
        final CustomerEntity customerEntity = customerDomainEntityMapper.toEntity(customer);
        return Optional.of(customerEntityRepository.save(customerEntity))
                .map(customerDomainEntityMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Failed to save customer"));
    }

    @Override
    public Customer findByEmail(final String email) {
        return Optional.of(customerEntityRepository.findByEmail(email))
                .map(customerDomainEntityMapper::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("customer not found"));
    }
}
