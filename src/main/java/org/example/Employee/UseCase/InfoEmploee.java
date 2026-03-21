package org.example.Employee.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Avatar.Service.AvatarService;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.response.InfoEmployeeResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoEmploee {
    private final EmployeeService employeeService;
    private final AvatarService avatarService;
    @Transactional
    public InfoEmployeeResponse infoEmployee(String login){
        Employee employee=employeeService.findEmployee(login);
        String avatar=avatarService.findAvatarName(employee.getAvatar());
        return new InfoEmployeeResponse(employee.getLogin(),avatar,employee.getExperts(),employee.getActivity());
    }
}
