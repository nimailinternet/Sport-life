package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.Service.AvatarService;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.EmployeeMapper;
import org.example.Employee.dto.response.InfoEmployeeTopResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InfoEmployeeTop {
    private final EmployeeService employeeService;
    private final AvatarService avatarService;
    private final EmployeeMapper employeeMapper;
    @Transactional
    public InfoEmployeeTopResponse infoEmployeeTop(){
        List<Employee> employees=employeeService.infoEmployeeTop();
        List<Avatar> avatars=employeeService.findAvatars(employees);
        List<String> names=avatarService.findAvatarsNames(avatars);
        return employeeMapper.toDtoInfoEmployeeTop(employees,names);
    }
}
