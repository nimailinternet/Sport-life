package org.example.Employee.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.example.Avatar.dto.request.FindNameAvatarRequest;

@Data
@Builder
public class CreateEmployeeRequest {
    @NotNull(message = "")
    @NotBlank(message = "")
    private String login;
    @NotBlank(message = "")
    @NotNull(message = "")
    private String password;
    @NotBlank(message = "")
    private String avatar;

    public String getLogin() {
        return login;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPassword() {
        return password;
    }
}
