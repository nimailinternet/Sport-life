package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Avatar.Service.AvatarService;
import org.example.Employee.Employee;
import org.example.Employee.EmployeePrincipal;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.EmployeeMapper;
import org.example.Employee.dto.response.InfoEmployeeResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoEmploee {
    private final EmployeeService employeeService;
    private final AvatarService avatarService;
    private final EmployeeMapper employeeMapper;
    @Transactional
    public InfoEmployeeResponse infoEmployee(EmployeePrincipal principal){
        Employee employee=employeeService.findEmployee(principal.getLogin());
        String avatar=avatarService.findAvatarName(employee.getAvatar());
        return employeeMapper.toDtoInfoEmployee(employee,avatar);
    }
}
