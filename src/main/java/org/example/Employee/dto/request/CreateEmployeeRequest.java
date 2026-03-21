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
    @NotBlank(message = "")
    @Size(min = 3,message = "")
    private String login;
    @NotBlank(message = "")
    @Size(min = 8,max = 20,message = "")
    private String password;
    @Pattern(regexp = "^(?!\\s*$).+",message = "")
    private String avatar;
}
