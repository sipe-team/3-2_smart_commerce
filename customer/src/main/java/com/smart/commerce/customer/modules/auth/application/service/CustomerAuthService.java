package com.smart.commerce.customer.modules.auth.application.service;

import com.smart.commerce.customer.modules.auth.application.CustomerSignInUseCase;
import com.smart.commerce.customer.modules.auth.application.CustomerSignUpUseCase;
import com.smart.commerce.customer.modules.auth.domain.Customer;
import com.smart.commerce.customer.modules.auth.domain.CustomerRepository;
import com.smart.commerce.customer.modules.auth.application.dto.CustomerSignInCommand;
import com.smart.commerce.customer.modules.auth.application.dto.CustomerSignUpCommand;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerAuthService implements CustomerSignUpUseCase, CustomerSignInUseCase {

    private final PasswordEncoder customerPasswordEncoder;
    private final CustomerRepository customerRepository;

    public CustomerAuthService(final PasswordEncoder customerPasswordEncoder, final CustomerRepository customerRepository) {
        this.customerPasswordEncoder = customerPasswordEncoder;
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer signUp(final CustomerSignUpCommand command) {
        final String password = customerPasswordEncoder.encode(command.password());
        return customerRepository.save(new Customer(null, command.email(), password));
    }

    @Override
    public Customer signIn(final CustomerSignInCommand command) {
        final Customer customer = customerRepository.findByEmail(command.email());
        customer.signIn(command.password(), customerPasswordEncoder::matches);
        return customer;
    }
}
