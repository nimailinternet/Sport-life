package org.example.Employee.dto.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    @Pattern(regexp = "^(?!\\s*$).+",message = "6")
    @Size(min =3,max = 20,message = "8")
    private String login;
    @Pattern(regexp = "^(?!\\s*$).+",message = "")
    private String avatar;
}
