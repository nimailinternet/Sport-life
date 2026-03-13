package org.example.Employee.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateExpertsEmployeeRequest {
    @NotBlank(message = "")
    private String experts;
    @Pattern(regexp = "^(?!\\s*$).+",message = "")
    private String login;
}
