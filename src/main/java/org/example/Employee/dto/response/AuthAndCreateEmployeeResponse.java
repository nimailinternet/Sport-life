package org.example.Employee.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthAndCreateEmployeeResponse {
    private String token;
}
