package org.example.Employee.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoEmployeeResponse {
    private String login;
    private String avatar;
    private String experts;
    private Long activity;
}
