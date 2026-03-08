package org.example.Employee;

import jakarta.validation.Valid;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.AuthEmployeeRequest;
import org.example.Employee.dto.request.CreateEmployeeRequest;
import org.example.Employee.dto.response.AuthAndCreateEmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/auth")
    public ResponseEntity<?> AuthEmployee(@Valid @RequestBody  AuthEmployeeRequest dto){
        AuthAndCreateEmployeeResponse authAndCreateEmployeeResponse =employeeService.AuthEmployee(dto);
        return ResponseEntity.ok(authAndCreateEmployeeResponse);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@Valid  @RequestBody CreateEmployeeRequest dto){
        AuthAndCreateEmployeeResponse authAndCreateEmployeeResponse=employeeService.CreateEmployee(dto);
        return ResponseEntity.ok(authAndCreateEmployeeResponse);
    }
}
