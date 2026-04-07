package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.Service.AvatarService;
import org.example.Employee.Employee;
import org.example.Employee.EmployeePrincipal;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.UpdateEmployeeRequest;
import org.example.Employee.dto.response.UpdateEmployeeResponse;
import org.example.Security.AuthClass;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateEmployee {
    private final EmployeeService employeeService;
    private final AvatarService avatarService;
    private final AuthClass authClass;

    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest dto, EmployeePrincipal principal){
        Avatar avatar=null;
        String message="";
        if(!dto.getAvatar().isBlank()) {
            avatar = avatarService.findAvatarByName(dto.getAvatar());
            message="avatar";
        }
        if(!dto.getLogin().isBlank()){
            message="login";
        }
        if(!dto.getAvatar().isBlank()&&!dto.getLogin().isBlank()){
            message="login and avatar";
        }
        Employee employee=employeeService.findEmployeeByLogin(principal.getLogin());
        employeeService.updateEmployee(dto.getLogin(),employee,avatar);
        String token = authClass.createToken(employee.getLogin());
        return new UpdateEmployeeResponse("Update "+message+" complete",token);
    }
}
