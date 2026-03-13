package org.example.Employee;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.*;
import org.example.Employee.dto.response.AuthAndCreateEmployeeResponse;
import org.example.Employee.dto.response.InfoEmployeeResponse;
import org.example.Employee.dto.response.UpdateEmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/auth")
    public ResponseEntity<?> authEmployee(@Valid @RequestBody  AuthEmployeeRequest dto){
        AuthAndCreateEmployeeResponse authAndCreateEmployeeResponse =employeeService.authEmployee(dto);
        return ResponseEntity.ok(authAndCreateEmployeeResponse);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@Valid  @RequestBody CreateEmployeeRequest dto){
        AuthAndCreateEmployeeResponse authAndCreateEmployeeResponse=employeeService.createEmployee(dto);
        return ResponseEntity.ok(authAndCreateEmployeeResponse);
    }

    @GetMapping("/info")
    public ResponseEntity<?> infoEmployee(){
        InfoAndUpdateActivityEmployeeRequest infoAndUpdateActivityEmployeeRequest =new InfoAndUpdateActivityEmployeeRequest(SecurityContextHolder.getContext().getAuthentication().getName());
        InfoEmployeeResponse infoEmployeeResponse=employeeService.infoEmployee(infoAndUpdateActivityEmployeeRequest);
        return ResponseEntity.ok(infoEmployeeResponse);
    }
    @GetMapping("/top")
    public  ResponseEntity<?> infoEmployeeTop(){
        return ResponseEntity.ok(employeeService.infoTopEmployee(new InfoAndUpdateActivityEmployeeRequest
                (SecurityContextHolder.getContext().getAuthentication().getName())));
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody UpdateEmployeeRequest dto){
        UpdateEmployeeResponse updateEmployeeResponse = employeeService.updateEmployee(dto);
        return ResponseEntity.ok(updateEmployeeResponse);
    }
    @PatchMapping("/activity")
    public ResponseEntity<?> updateEmployeeActivity(){
        InfoAndUpdateActivityEmployeeRequest result=
                new InfoAndUpdateActivityEmployeeRequest
                        (SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.ok(employeeService.updateEActivityEmployee(result));
    }
    @PatchMapping("/experts")
    public ResponseEntity<?> updateExpertsEmployee(@Valid @RequestBody UpdateExpertsEmployeeRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        dto.setLogin(login);
        UpdateEmployeeResponse updateEmployeeResponse =employeeService.updateExpertsEmployee(dto);
        return ResponseEntity.ok(updateEmployeeResponse);
    }
}
