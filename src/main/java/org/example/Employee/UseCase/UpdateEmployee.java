package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.Service.AvatarService;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.UpdateEmployeeRequest;
import org.example.Employee.dto.response.UpdateEmployeeResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateEmployee {
    private final EmployeeService employeeService;
    private final AvatarService avatarService;
    @Transactional
    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest dto,String login){
        Avatar avatar=null;
        if(!dto.getAvatar().isEmpty()) {
            avatar = avatarService.findAvatar(dto.getAvatar());
        }
        String response= employeeService.updateEmployee(dto.getLogin(),login,avatar);
        return new UpdateEmployeeResponse(response);
    }
}
