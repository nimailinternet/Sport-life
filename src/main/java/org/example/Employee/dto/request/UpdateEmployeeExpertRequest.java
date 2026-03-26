package org.example.Employee.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeExpertRequest {
    @NotBlank(message = "")
    private String experts;
    private String login;
}
