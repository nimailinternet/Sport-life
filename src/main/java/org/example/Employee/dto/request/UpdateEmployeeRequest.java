package org.example.Employee.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UpdateEmployeeRequest {
    @Pattern(regexp = "^(?!\\s*$).+",message = "")
    private String login;
    @Pattern(regexp = "^(?!\\s*$).+",message = "")
    private String avatar;
}
