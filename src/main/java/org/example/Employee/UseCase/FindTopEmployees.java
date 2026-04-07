package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.Service.AvatarService;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.EmployeeMapper;
import org.example.Employee.dto.response.FindTopEmployeesResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FindTopEmployees {
    private final EmployeeService employeeService;
    private final AvatarService avatarService;
    private final EmployeeMapper employeeMapper;

    public FindTopEmployeesResponse findTopEmployees(){
        List<Employee> employees=employeeService.findTopEmployees();
        Map<Employee,String> names=avatarService.getAvatarsNames(employeeMapper.toMapEmployee(employees));
        return employeeMapper.toDtoTopEmployees(employees,names);
    }
}
