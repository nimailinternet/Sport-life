package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.UpdateExpertsEmployeeRequest;
import org.example.Employee.dto.response.UpdateExpertsEmployeeResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpertsEmployee {
    private final EmployeeService employeeService;
    @Transactional
    public UpdateExpertsEmployeeResponse updateExperts(UpdateExpertsEmployeeRequest dto,String login){
        String response=employeeService.updateExpertsEmployee(login,dto.getExperts());
        return new UpdateExpertsEmployeeResponse(response);
    }
}
