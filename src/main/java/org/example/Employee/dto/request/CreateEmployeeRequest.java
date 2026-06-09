package org.example.Employee.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {
    @NotBlank(message = "6")
    @Size(min = 3,max=20,message = "8")
    private String login;
    @NotBlank(message = "7")
    @Size(min = 8,max = 20,message = "9")
    private String password;
}
