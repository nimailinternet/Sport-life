package org.example.Employee.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthEmployeeRequest {
    @NotBlank(message = "")
    private String login;
    @NotBlank(message = "")
    private String password;

    public String getLogin() {
        return login;

    }
    public String getPassword() {
        return password;

    }
}
