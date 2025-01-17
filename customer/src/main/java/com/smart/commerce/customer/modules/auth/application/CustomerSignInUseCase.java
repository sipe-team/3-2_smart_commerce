package com.smart.commerce.customer.modules.auth.application;

import com.smart.commerce.customer.modules.auth.application.dto.CustomerSignInCommand;
import com.smart.commerce.customer.modules.auth.domain.Customer;

public interface CustomerSignInUseCase {
    Customer signIn(CustomerSignInCommand command);
}
