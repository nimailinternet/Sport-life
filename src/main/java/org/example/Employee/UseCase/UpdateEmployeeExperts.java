package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Employee.EmployeePrincipal;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.UpdateEmployeeExpertsRequest;
import org.example.Employee.dto.response.EmployeeDetailsResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateEmployeeExperts {
    private final EmployeeService employeeService;

    public EmployeeDetailsResponse.UpdateEmployeeExpertResponse updateExperts(UpdateEmployeeExpertsRequest dto, EmployeePrincipal principal){
        employeeService.updateEmployeeExpert(principal.getLogin(),dto.getExperts());
        return new EmployeeDetailsResponse.UpdateEmployeeExpertResponse("Update experts complete");
    }
}
