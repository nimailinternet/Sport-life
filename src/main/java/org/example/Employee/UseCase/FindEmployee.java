package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.Service.AvatarService;
import org.example.Employee.Employee;
import org.example.Employee.EmployeePrincipal;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.EmployeeMapper;
import org.example.Employee.dto.response.FindEmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FindEmployee {
    private final EmployeeService employeeService;
    private final AvatarService avatarService;
    private final EmployeeMapper employeeMapper;

    public FindEmployeeResponse findEmployee(EmployeePrincipal principal){
        List<Employee> employees=new ArrayList<>();
        Employee employee=employeeService.findEmployeeByLogin(principal.getLogin());
        employees.add(employee);
        Map<Employee,String> avatar=avatarService.getAvatarsNames(employeeMapper.toMapEmployee(employees));
        return employeeMapper.toDtoEmployee(avatar);
    }
}
