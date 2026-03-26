package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.UpdateEmployeeExpertRequest;
import org.example.Employee.dto.response.UpdateEmployeeExpertResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateEmployeeExpert {
    private final EmployeeService employeeService;
    @Transactional
    public UpdateEmployeeExpertResponse updateExperts(UpdateEmployeeExpertRequest dto, String login){
        String response=employeeService.updateEmployeeExpert(login,dto.getExperts());
        return new UpdateEmployeeExpertResponse(response);
    }
}
