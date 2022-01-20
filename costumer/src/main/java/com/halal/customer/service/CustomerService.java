package com.halal.customer.service;

import com.halal.clients.fraud.FraudCheckResponse;
import com.halal.clients.fraud.FraudClient;
import com.halal.customer.model.Customer;
import com.halal.customer.model.CustomerRegistrationRequest;
import com.halal.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(
        CustomerRepository customerRepository,
//        RestTemplate restTemplate,
        FraudClient fraudClient
) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // TODO: check if email valid
        // TODO: check if email not taken
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
        // TODO: send notification
    }
}
