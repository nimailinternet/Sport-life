package org.example.Employee.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoEmployeeResponse {
    private String login;
    private String avatar;
    private String experts;
    private Long activity;

    public InfoEmployeeResponse(String login, String experts, Long activity, String avatar) {

    }
}
