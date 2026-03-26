package org.example.Employee.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    @Pattern(regexp = "^(?!\\s*$).+",message = "")
    private String login;
    @Pattern(regexp = "^(?!\\s*$).+",message = "")
    private String avatar;
    private String principalLogin;
}
