package org.example.Employee;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Employee.UseCase.*;
import org.example.Employee.dto.request.*;
import org.example.Employee.dto.response.AuthEmployeeResponse;
import org.example.Employee.dto.response.UpdateEmployeeExpertResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final AuthEmployee authEmployee;
    private final CreateEmployee createEmployee;
    private final InfoEmploee infoEmploee;
    private final InfoEmployeeTop infoEmployeeTop;
    private final UpdateEmployee updateEmployee;
    private final UpdateEmployeeActivity updateEmployeeActivity;
    private final UpdateEmployeeExpert updateEmployeeExpert;

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
    public ResponseEntity<?> infoEmployee(@AuthenticationPrincipal EmployeePrincipal principal){
        return ResponseEntity.ok(infoEmploee.infoEmployee(principal));
    }
    @GetMapping("/top")
    public  ResponseEntity<?> infoEmployeeTop(){
        return ResponseEntity.ok(infoEmployeeTop.infoEmployeeTop());

    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody UpdateEmployeeRequest dto, @AuthenticationPrincipal EmployeePrincipal principal){
        dto.setPrincipalLogin(principal.getLogin());
        return ResponseEntity.ok(updateEmployee.updateEmployee(dto));
    }
    @PatchMapping("/activity")
    public ResponseEntity<?> updateEmployeeActivity(@AuthenticationPrincipal EmployeePrincipal principal){
        return ResponseEntity.ok(updateEmployeeActivity.updateActivity(principal.getLogin()));
    }
    @PatchMapping("/experts")
    public ResponseEntity<?> updateExpertsEmployee(@Valid @RequestBody UpdateEmployeeExpertRequest dto, @AuthenticationPrincipal EmployeePrincipal principal){

        dto.setLogin(principal.getLogin());
        UpdateEmployeeExpertResponse response= updateEmployeeExpert.updateExperts(dto);
        return ResponseEntity.ok(response);
    }
}
