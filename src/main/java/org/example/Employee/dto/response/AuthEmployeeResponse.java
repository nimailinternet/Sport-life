package org.example.Employee.dto.response;

public  class AuthEmployeeResponse extends EmployeeRegistrationDetails{
    public AuthEmployeeResponse(String token, String refreshToken) {
        super(token,refreshToken);
    }
}
