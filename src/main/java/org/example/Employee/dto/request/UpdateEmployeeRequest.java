package org.example.Employee.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    @Pattern(regexp = "^(?!\\s*$).+",message = "")
    private String login;
    @Pattern(regexp = "^(?!\\s*$).+",message = "")
    private String avatar;

    public String getLogin() {
        return login;

    }
    public String getAvatar() {
        return avatar;

    }
}
