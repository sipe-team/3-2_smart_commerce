package com.smart.commerce.customer.modules.auth.application;

import com.smart.commerce.customer.modules.auth.application.dto.CustomerSignUpCommand;
import com.smart.commerce.customer.modules.auth.domain.Customer;

public interface CustomerSignUpUseCase {
    Customer signUp(CustomerSignUpCommand command);
}
