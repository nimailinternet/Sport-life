package org.example.Employee;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.*;
import org.example.Employee.dto.response.AuthAndCreateEmployeeResponse;
import org.example.Employee.dto.response.InfoEmployeeResponse;
import org.example.Employee.dto.response.UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse;
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
        InfoAndUpdateActivityAndInfoTopEmployeeRequest infoAndUpdateActivityAndInfoTopEmployeeRequest =new InfoAndUpdateActivityAndInfoTopEmployeeRequest(SecurityContextHolder.getContext().getAuthentication().getName());
        InfoEmployeeResponse infoEmployeeResponse=employeeService.infoEmployee(infoAndUpdateActivityAndInfoTopEmployeeRequest);
        return ResponseEntity.ok(infoEmployeeResponse);
    }
    @GetMapping("/top")
    public  ResponseEntity<?> infoEmployeeTop(){
        return ResponseEntity.ok(employeeService.infoTopEmployee(new InfoAndUpdateActivityAndInfoTopEmployeeRequest
                (SecurityContextHolder.getContext().getAuthentication().getName())));
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody UpdateEmployeeRequest dto){
        UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse updateAndUpdateActivityAndUpdateExpertsEmployeeResponse = employeeService.updateEmployee(dto);
        return ResponseEntity.ok(updateAndUpdateActivityAndUpdateExpertsEmployeeResponse);
    }
    @PatchMapping("/activity")
    public ResponseEntity<?> updateEmployeeActivity(){
        InfoAndUpdateActivityAndInfoTopEmployeeRequest result=
                new InfoAndUpdateActivityAndInfoTopEmployeeRequest
                        (SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.ok(employeeService.updateActivityEmployee(result));
    }
    @PatchMapping("/experts")
    public ResponseEntity<?> updateExpertsEmployee(@Valid @RequestBody UpdateExpertsEmployeeRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        dto.setLogin(login);
        UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse updateAndUpdateActivityAndUpdateExpertsEmployeeResponse =employeeService.updateExpertsEmployee(dto);
        return ResponseEntity.ok(updateAndUpdateActivityAndUpdateExpertsEmployeeResponse);
    }
}
