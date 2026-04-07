package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Employee.EmployeePrincipal;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.response.EmployeeDetailsResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateEmployeeActivity {
    private final EmployeeService employeeService;

    public EmployeeDetailsResponse.UpdateEmployeeActivityResponse updateActivity(EmployeePrincipal principal){
        employeeService.updateEmployeeActivity(principal.getLogin());
        return new EmployeeDetailsResponse.UpdateEmployeeActivityResponse("Update activity complete");

    }
}
