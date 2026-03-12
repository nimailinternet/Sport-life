package org.example.Employee.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class InfoEmployeeTopResponse {
    private List<EmployeeTop> top;


    @Data
    @NoArgsConstructor
    public static class EmployeeTop{
        private String login;
        private Long activity;
        private String avatar;
    }
}
