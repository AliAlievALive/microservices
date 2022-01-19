package com.halal.customer.domen;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
