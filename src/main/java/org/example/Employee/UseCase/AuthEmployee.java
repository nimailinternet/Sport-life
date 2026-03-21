package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.AuthEmployeeRequest;
import org.example.Employee.dto.response.AuthEmployeeResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthEmployee {
    private final EmployeeService employeeService;
    @Transactional
    public AuthEmployeeResponse authEmployee(AuthEmployeeRequest dto){
        String token= employeeService.authEmployee(dto.getLogin(), dto.getPassword());
        return new AuthEmployeeResponse(token);
    }
}
