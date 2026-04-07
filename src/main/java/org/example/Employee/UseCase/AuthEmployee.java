package org.example.Employee.UseCase;

import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.AuthEmployeeRequest;
import org.example.Employee.dto.response.EmployeeDetailsResponse;
import org.example.Security.AuthClass;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthEmployee {
    private final EmployeeService employeeService;
    private final AuthClass authClass;

    public EmployeeDetailsResponse.AuthEmployeeResponse authEmployee(AuthEmployeeRequest dto){
        Employee employee=employeeService.authEmployee(dto.getLogin(),dto.getPassword());
        String token=authClass.createToken(employee.getLogin());
        return new EmployeeDetailsResponse.AuthEmployeeResponse(token);
    }
}
