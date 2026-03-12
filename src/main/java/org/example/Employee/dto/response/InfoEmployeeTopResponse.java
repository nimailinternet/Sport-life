package org.example.Employee.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class InfoEmployeeTopResponse {
    private List<EmployeeTop> top;

    public List<EmployeeTop> getTop() {
        return top;

    }
    public void setTop(List<EmployeeTop> top) {
        this.top = top;

    }



    @Data
    @NoArgsConstructor
    public static class EmployeeTop{
        private String login;
        private Long activity;
        private String avatar;

        public void setLogin(String login) {
            this.login = login;

        }
        public void setAvatar(String avatar) {
            this.avatar = avatar;

        }
        public void setActivity(Long activity) {
            this.activity = activity;

        }
    }
}
