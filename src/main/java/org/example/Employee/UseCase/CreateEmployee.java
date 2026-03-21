package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.CreateEmployeeRequest;
import org.example.Employee.dto.response.CreateEmployeeResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEmployee {
    private final EmployeeService employeeService;

    @Transactional
    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest dto){
        String token= employeeService.createEmployee(dto.getLogin(), dto.getPassword(), dto.getAvatar());
        return new CreateEmployeeResponse(token);
    }
}
