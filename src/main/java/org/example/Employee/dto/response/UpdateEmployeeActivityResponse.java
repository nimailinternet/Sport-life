package org.example.Employee.dto.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateEmployeeActivityResponse extends EmployeeDetailsResponse {
    public UpdateEmployeeActivityResponse(String message){
        super(message);
    }
}
