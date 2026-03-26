package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.Service.AvatarService;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.CreateEmployeeRequest;
import org.example.Employee.dto.response.CreateEmployeeResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEmployee {
    private final EmployeeService employeeService;
    private final AvatarService avatarService;

    @Transactional
    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest dto){
        Avatar avatar=avatarService.findAvatar(dto.getAvatar());
        String token= employeeService.createEmployee(dto.getLogin(), dto.getPassword(),avatar);
        return new CreateEmployeeResponse(token);
    }
}
