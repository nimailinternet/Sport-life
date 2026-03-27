package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.Service.AvatarService;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.response.InfoEmployeeTopResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InfoTopEmployee {
    private final EmployeeService employeeService;
    private final AvatarService avatarService;
    @Transactional
    public InfoEmployeeTopResponse infoTopEmployee(){
        List<Employee> employees=employeeService.infoTopEmployee();
        InfoEmployeeTopResponse infoEmployeeTopResponse=new InfoEmployeeTopResponse();
        infoEmployeeTopResponse.setTop(new ArrayList<>());
        List<InfoEmployeeTopResponse.EmployeeTop> top=infoEmployeeTopResponse.getTop();
        List<Avatar> avatars=employeeService.findAvatars(employees);
        List<String> names=avatarService.findAvatarsNames(avatars);
        List<Map<String, Object>> results=employeeService.infoTopEmployees(employees,names);
        for(Map<String,Object> result:results){
            InfoEmployeeTopResponse.EmployeeTop employeeTop=new InfoEmployeeTopResponse.EmployeeTop();
            employeeTop.setLogin((String) result.get("login"));
            employeeTop.setAvatar((String) result.get("avatar"));
            employeeTop.setActivity((Long) result.get("activity"));
            top.add(employeeTop);
        }
        infoEmployeeTopResponse.setTop(top);
        return infoEmployeeTopResponse;
    }
}
