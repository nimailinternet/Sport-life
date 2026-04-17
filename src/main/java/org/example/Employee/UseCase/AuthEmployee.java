package org.example.Employee.UseCase;

import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.AuthEmployeeRequest;
import org.example.Employee.dto.response.AuthEmployeeResponse;
import org.example.Employee.dto.response.EmployeeDetailsResponse;
import org.example.Employee.dto.response.EmployeeRegistrationDetails;
import org.example.Security.AuthClass;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthEmployee {
    private final EmployeeService employeeService;
    private final AuthClass authClass;

    public AuthEmployeeResponse authEmployee(AuthEmployeeRequest dto){
        Employee employee=employeeService.authEmployee(dto.getLogin(),dto.getPassword());
        String tokenAccess =authClass.createToken(employee.getLogin());
        String tokenRefresh=authClass.createRefresh(employee.getLogin());
        return new AuthEmployeeResponse(tokenAccess, tokenRefresh);
    }
}
