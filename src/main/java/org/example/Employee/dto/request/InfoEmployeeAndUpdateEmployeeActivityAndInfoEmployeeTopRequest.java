package org.example.Employee.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InfoEmployeeAndUpdateEmployeeActivityAndInfoEmployeeTopRequest {
    @NotBlank(message = "")
    private String login;
}
