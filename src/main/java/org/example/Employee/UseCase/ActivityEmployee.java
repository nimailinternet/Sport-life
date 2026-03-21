package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.response.UpdateActivityEmployeeResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityEmployee {
    private final EmployeeService employeeService;
    @Transactional
    public UpdateActivityEmployeeResponse updateActivity(String login){
        String response=employeeService.updateActivityEmployee(login);
        return new UpdateActivityEmployeeResponse(response);

    }
}
