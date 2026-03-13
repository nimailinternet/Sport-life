package org.example.Employee.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoEmployeeTopResponse {
    private List<EmployeeTop> top;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EmployeeTop{
        private String login;
        private Long activity;
        private String avatar;
    }
}
