package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.Service.AvatarService;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.CreateEmployeeRequest;
import org.example.Employee.dto.response.EmployeeDetailsResponse;
import org.example.Security.AuthClass;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEmployee {
    private final EmployeeService employeeService;
    private final AvatarService avatarService;
    private final AuthClass authClass;

    public EmployeeDetailsResponse.CreateEmployeeResponse createEmployee(CreateEmployeeRequest dto){
        Avatar avatar=avatarService.findAvatarByName(dto.getAvatar());
        Employee employee= employeeService.createEmployee(dto.getLogin(), dto.getPassword(),avatar);
        String token=authClass.createToken(employee.getLogin());
        return new EmployeeDetailsResponse.CreateEmployeeResponse(token);
    }
}
