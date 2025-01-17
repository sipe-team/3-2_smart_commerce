package com.smart.commerce.customer.modules.auth.api;

import com.smart.commerce.customer.modules.auth.api.dto.CustomerSignInRequest;
import com.smart.commerce.customer.modules.auth.api.dto.CustomerSignInResponse;
import com.smart.commerce.customer.modules.auth.api.dto.CustomerSignUpRequest;
import com.smart.commerce.customer.modules.auth.api.dto.CustomerSignUpResponse;
import com.smart.commerce.customer.modules.auth.application.CustomerSignInUseCase;
import com.smart.commerce.customer.modules.auth.application.CustomerAccessTokenCreateUseCase;
import com.smart.commerce.customer.modules.auth.application.CustomerSignUpUseCase;
import com.smart.commerce.customer.modules.auth.domain.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequestMapping("/customer/auth")
@RestController
public class CustomerAuthApi {

    private final CustomerSignUpUseCase customerSignUpUseCase;
    private final CustomerSignInUseCase customerSignInUseCase;
    private final CustomerAccessTokenCreateUseCase customerAccessTokenCreateUseCase;

    public CustomerAuthApi(final CustomerSignUpUseCase customerSignUpUseCase,
                           final CustomerSignInUseCase customerSignInUseCase,
                           final CustomerAccessTokenCreateUseCase customerAccessTokenCreateUseCase) {
        this.customerSignUpUseCase = customerSignUpUseCase;
        this.customerSignInUseCase = customerSignInUseCase;
        this.customerAccessTokenCreateUseCase = customerAccessTokenCreateUseCase;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<CustomerSignUpResponse> signUp(
            @RequestBody final CustomerSignUpRequest request
    ) {
        customerSignUpUseCase.signUp(request.toCommand());
        return ResponseEntity.created(URI.create("/auth/sign-in")).body(new CustomerSignUpResponse("ok"));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<CustomerSignInResponse> signIn(
            @RequestBody final CustomerSignInRequest request
    ) {
        final Customer customer = customerSignInUseCase.signIn(request.toCommand());
        final String accessToken = customerAccessTokenCreateUseCase.create(customer.getId());
        return ResponseEntity.ok().body(new CustomerSignInResponse(accessToken));
    }
}
