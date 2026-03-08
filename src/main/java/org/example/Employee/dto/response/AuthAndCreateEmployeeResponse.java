package org.example.Employee.dto.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthAndCreateEmployeeResponse {
    private String token;

    public AuthAndCreateEmployeeResponse(String token) {
        this.token=token;
    }
}
