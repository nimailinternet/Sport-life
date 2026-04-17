package org.example.Employee.UseCase;

import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.CreateEmployeeRequest;
import org.example.Employee.dto.response.CreateEmployeeResponse;
import org.example.Employee.dto.response.EmployeeRegistrationDetails;
import org.example.Security.AuthClass;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEmployee {
    private final EmployeeService employeeService;
    private final AuthClass authClass;

    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest dto){
        Employee employee= employeeService.createEmployee(dto.getLogin(), dto.getPassword());
        String token=authClass.createToken(employee.getLogin());
        String refreshToken=authClass.createRefresh(employee.getLogin());
        return new CreateEmployeeResponse(token, refreshToken);
    }
}
