package org.example.Employee.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.parameters.P;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailsResponse {
    private String message;

    public static class UpdateEmployeeActivityResponse extends EmployeeDetailsResponse {
        public UpdateEmployeeActivityResponse(String message){
            super(message);
        }
    }
    public static class UpdateEmployeeExpertResponse extends EmployeeDetailsResponse {
        public UpdateEmployeeExpertResponse(String message) {
            super(message);
        }
    }
    public static class CreateEmployeeResponse extends EmployeeDetailsResponse {
        public CreateEmployeeResponse(String message) {
            super(message);
        }
    }
    public static class AuthEmployeeResponse extends EmployeeDetailsResponse {
        public AuthEmployeeResponse(String message){
            super(message);
        }
    }
}
