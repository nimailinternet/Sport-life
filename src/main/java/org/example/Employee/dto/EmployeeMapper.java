package org.example.Employee.dto;

import org.example.Employee.Employee;
import org.example.Employee.EmployeePrincipal;
import org.example.Employee.dto.response.InfoEmployeeResponse;
import org.example.Employee.dto.response.InfoEmployeeTopResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeMapper {
    public InfoEmployeeResponse toDtoInfoEmployee(Employee employee,String avatarName){
        return new InfoEmployeeResponse(employee.getLogin(),avatarName,employee.getExperts(),employee.getActivity());
    }
    public InfoEmployeeTopResponse toDtoInfoEmployeeTop(List<Employee> employees,List<String> names){
        InfoEmployeeTopResponse infoEmployeeTopResponse=new InfoEmployeeTopResponse();
        infoEmployeeTopResponse.setTop(new ArrayList<>());
        List<InfoEmployeeTopResponse.EmployeeTop> top=infoEmployeeTopResponse.getTop();
        List<Map<String,Object>> responses=new ArrayList<>();
        int i=0;
        for (Employee employee:employees) {
            Map<String,Object> result=new LinkedHashMap<>();
            String avatar=names.get(i);
            i+=1;
            result.put("login",employee.getLogin());
            result.put("activity",employee.getActivity());
            result.put("avatar",avatar);
            responses.add(result);
        }
        for(Map<String,Object> response:responses){
            InfoEmployeeTopResponse.EmployeeTop employeeTop=new InfoEmployeeTopResponse.EmployeeTop();
            employeeTop.setLogin((String) response.get("login"));
            employeeTop.setAvatar((String) response.get("avatar"));
            employeeTop.setActivity((Long) response.get("activity"));
            top.add(employeeTop);
        }
        return new InfoEmployeeTopResponse(top);
    }
}
