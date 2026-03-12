package org.example.Employee.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateEmployeeExpertiseRequest{
    @NotBlank(message = "")
    private String experts;
}
