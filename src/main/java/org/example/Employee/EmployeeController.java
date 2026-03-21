package org.example.Employee;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Employee.UseCase.*;
import org.example.Employee.dto.request.*;
import org.example.Employee.dto.response.AuthEmployeeResponse;
import org.example.Employee.dto.response.UpdateExpertsEmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final AuthEmployee authEmployee;
    private final CreateEmployee createEmployee;
    private final InfoEmploee infoEmploee;
    private final InfoTopEmployee infoTopEmployee;
    private final UpdateEmployee updateEmployee;
    private final ActivityEmployee activityEmployee;
    private final ExpertsEmployee expertsEmployee;

    @PostMapping("/auth")
    public ResponseEntity<?> authEmployee(@Valid @RequestBody  AuthEmployeeRequest dto){
        AuthEmployeeResponse response= authEmployee.authEmployee(dto);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@Valid  @RequestBody CreateEmployeeRequest dto){
        return ResponseEntity.ok(createEmployee.createEmployee(dto));
    }

    @GetMapping("/info")
    public ResponseEntity<?> infoEmployee(){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(infoEmploee.infoEmployee(login));
    }
    @GetMapping("/top")
    public  ResponseEntity<?> infoEmployeeTop(){
        return ResponseEntity.ok(infoTopEmployee.infoTopEmployee());
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody UpdateEmployeeRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(updateEmployee.updateEmployee(dto,login));
    }
    @PatchMapping("/activity")
    public ResponseEntity<?> updateEmployeeActivity(){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(activityEmployee.updateActivity(login));
    }
    @PatchMapping("/experts")
    public ResponseEntity<?> updateExpertsEmployee(@Valid @RequestBody UpdateExpertsEmployeeRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        UpdateExpertsEmployeeResponse response= expertsEmployee.updateExperts(dto,login);
        return ResponseEntity.ok(response);
    }
}
