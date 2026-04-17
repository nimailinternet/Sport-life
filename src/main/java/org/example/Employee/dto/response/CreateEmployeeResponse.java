package org.example.Employee.dto.response;

public  class CreateEmployeeResponse extends EmployeeRegistrationDetails {
    public CreateEmployeeResponse(String token, String refreshToken) {
        super(token, refreshToken);
    }
}
