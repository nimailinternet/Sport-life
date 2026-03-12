package org.example.Employee;

import jakarta.validation.Valid;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.*;
import org.example.Employee.dto.response.AuthAndCreateEmployeeResponse;
import org.example.Employee.dto.response.InfoEmployeeResponse;
import org.example.Employee.dto.response.UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

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
        InfoEmployeeAndUpdateEmployeeActivityAndInfoEmployeeTopRequest infoEmployeeAndUpdateEmployeeActivityAndInfoEmployeeTopRequest =new InfoEmployeeAndUpdateEmployeeActivityAndInfoEmployeeTopRequest(SecurityContextHolder.getContext().getAuthentication().getName());
        InfoEmployeeResponse infoEmployeeResponse=employeeService.infoEmployee(infoEmployeeAndUpdateEmployeeActivityAndInfoEmployeeTopRequest);
        return ResponseEntity.ok(infoEmployeeResponse);
    }
    @GetMapping("/top")
    public  ResponseEntity<?> infoEmployeeTop(){
        return ResponseEntity.ok(employeeService.infoEmployeeTop(new InfoEmployeeAndUpdateEmployeeActivityAndInfoEmployeeTopRequest
                (SecurityContextHolder.getContext().getAuthentication().getName())));
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody UpdateEmployeeRequest dto){
        UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse updateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse = employeeService.updateEmployee(dto);
        return ResponseEntity.ok(updateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse);
    }
    @PatchMapping("/activity")
    public ResponseEntity<?> updateEmployeeActivity(){
        InfoEmployeeAndUpdateEmployeeActivityAndInfoEmployeeTopRequest result=
                new InfoEmployeeAndUpdateEmployeeActivityAndInfoEmployeeTopRequest
                        (SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.ok(employeeService.updateEmployeeActivity(result));
    }
    @PatchMapping("/experts")
    public ResponseEntity<?> updateEmployeeExperts(@Valid @RequestBody  UpdateEmployeeExpertiseRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse updateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse =employeeService.updateEmployeeExpertise(dto,login);
        return ResponseEntity.ok(updateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse);
    }
}
