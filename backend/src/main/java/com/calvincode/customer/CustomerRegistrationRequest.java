package com.calvincode.customer;

public record CustomerRegistrationRequest(
        String name,
        String email,
        Integer age
) {
}
