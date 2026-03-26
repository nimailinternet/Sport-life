package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.response.UpdateEmployeeActivityResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateEmployeeActivity {
    private final EmployeeService employeeService;
    @Transactional
    public UpdateEmployeeActivityResponse updateActivity(String login){
        String response=employeeService.updateEmployeeActivity(login);
        return new UpdateEmployeeActivityResponse(response);

    }
}
