package org.example.Employee.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UpdateEmployeeResponse {
    private String update;
    private String token;
}
