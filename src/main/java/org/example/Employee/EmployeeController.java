package org.example.Employee;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Employee.UseCase.*;
import org.example.Employee.dto.request.*;
import org.example.Employee.dto.response.SplashResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final AuthEmployee authEmployee;
    private final CreateEmployee createEmployee;
    private final FindEmployee findEmployee;
    private final FindTopEmployees findTopEmployees;
    private final UpdateEmployee updateEmployee;
    private final UpdateEmployeeActivity updateEmployeeActivity;
    private final UpdateEmployeeExperts updateEmployeeExperts;
    private final RefreshEmployeeToken refreshEmployeeToken;

    @PostMapping("/auth")
    public ResponseEntity<?> authEmployee(@Valid @RequestBody  AuthEmployeeRequest dto){
        return ResponseEntity.ok(authEmployee.authEmployee(dto));
    }
    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@Valid  @RequestBody CreateEmployeeRequest dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(createEmployee.createEmployee(dto));
    }
    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@Valid @RequestBody RefreshEmployeeTokenRequest dto){
        return ResponseEntity.ok(refreshEmployeeToken.refresh(dto));
    }

    @GetMapping("/info")
    public ResponseEntity<?> findEmployee(@AuthenticationPrincipal EmployeePrincipal principal){
        return ResponseEntity.ok(findEmployee.findEmployee(principal));
    }
    @GetMapping("/top")
    public  ResponseEntity<?> findTopEmployees(){
        return ResponseEntity.ok(findTopEmployees.findTopEmployees());
    }
    @GetMapping("/splash")
    public ResponseEntity<?> splash(){
        return ResponseEntity.ok(new SplashResponse("welcome"));
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody UpdateEmployeeRequest dto, @AuthenticationPrincipal EmployeePrincipal principal){
        return ResponseEntity.ok(updateEmployee.updateEmployee(dto,principal));
    }
    @PatchMapping("/activity")
    public ResponseEntity<?> updateEmployeeActivity(@AuthenticationPrincipal EmployeePrincipal principal){
        return ResponseEntity.ok(updateEmployeeActivity.updateActivity(principal));
    }
    @PatchMapping("/experts")
    public ResponseEntity<?> updateEmployeeExperts(@Valid @RequestBody UpdateEmployeeExpertsRequest dto, @AuthenticationPrincipal EmployeePrincipal principal){
        return ResponseEntity.ok(updateEmployeeExperts.updateExperts(dto,principal));
    }
}
