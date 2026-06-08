package org.example.Employee.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthEmployeeRequest {
    @NotBlank(message = "6")
    private String login;
    @NotBlank(message = "7")
    private String password;
}
