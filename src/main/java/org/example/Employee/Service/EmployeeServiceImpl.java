package org.example.Employee.Service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.Service.AvatarService;
import org.example.Employee.Employee;
import org.example.Employee.EmployeeRepository;
import org.example.Employee.dto.request.*;
import org.example.Employee.dto.response.AuthAndCreateEmployeeResponse;
import org.example.Employee.dto.response.InfoEmployeeResponse;
import org.example.Employee.dto.response.InfoEmployeeTopResponse;
import org.example.Employee.dto.response.UpdateEmployeeResponse;
import org.example.Exceptions.EmployeeFoundException;
import org.example.Exceptions.EmployeeNotFoundException;
import org.example.Exceptions.UnauthorizedEmployeeException;
import org.example.Security.AuthClass;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private  final AuthClass authClass;
    private final AvatarService avatarService;

    @Override
    public String infoExercise_findExpertsEmployee(String login) {
        Employee employee=employeeRepository.findByLogin(login).orElseThrow(()->new EmployeeNotFoundException("",HttpStatus.UNAUTHORIZED));
        return employee.getExperts();
    }
    @Override
    public Employee FavouritesCreateDeleteInfoAndCalendarInfoDeleteCreate_FindEmployee(String login) {
        return employeeRepository.findByLogin(login).orElseThrow(()->new EmployeeNotFoundException("",HttpStatus.UNAUTHORIZED));
    }


    @Override
    public AuthAndCreateEmployeeResponse authEmployee(AuthEmployeeRequest dto) {
        Employee employee=employeeRepository
                .findByLogin(dto.getLogin())
                .orElseThrow(()->new EmployeeNotFoundException("",HttpStatus.NOT_FOUND));
        if(!passwordEncoder.matches(employee.getPassword(),dto.getPassword())){
            throw new UnauthorizedEmployeeException("",HttpStatus.UNAUTHORIZED);
        }
        String token=authClass.createToken(dto.getLogin());
        return new AuthAndCreateEmployeeResponse(token);
    }
    @Override
    public AuthAndCreateEmployeeResponse createEmployee(CreateEmployeeRequest dto) {
        if(employeeRepository.findByLogin(dto.getLogin()).isPresent()){
            throw new EmployeeFoundException("",HttpStatus.CONFLICT);
        }
        Employee employee;
        if(!dto.getAvatar().isEmpty()){
            Avatar avatar=avatarService.CreateEmployee_FindAvatar(dto.getAvatar());
            String password=passwordEncoder.encode(dto.getPassword());
             employee=new Employee(dto.getLogin(),avatar,password);
        }else{
            String password=passwordEncoder.encode(dto.getPassword());
            employee=new Employee(dto.getLogin(),password);
        }
        employeeRepository.save(employee);
        String token=authClass.createToken(dto.getLogin());
        return new AuthAndCreateEmployeeResponse(token);
    }
    @Override
    public UpdateEmployeeResponse updateExpertsEmployee(UpdateExpertsEmployeeRequest dto) {
        Employee employee=employeeRepository.findByLogin(dto.getLogin()).orElseThrow(()->new EmployeeNotFoundException("",HttpStatus.UNAUTHORIZED));
        employee.setExperts(dto.getExperts());
        return new UpdateEmployeeResponse("Update");
    }
    @Override
    public InfoEmployeeResponse infoEmployee(@Valid InfoAndUpdateActivityEmployeeRequest dto) {
        Employee employee=employeeRepository.findByLogin(dto.getLogin()).orElseThrow(()->new EmployeeNotFoundException("",HttpStatus.NOT_FOUND));
        return new InfoEmployeeResponse(dto.getLogin(),
                avatarService.InfoEmployeeAndUpdateEmployee_FindAvatarName(employee.getAvatar()),
                employee.getExperts(),
                employee.getActivity());
    }
    @Override
    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest dto) {
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        Employee employee=employeeRepository.findByLogin(login).orElseThrow(()->new EmployeeNotFoundException("",HttpStatus.NOT_FOUND));
        UpdateEmployeeResponse updateEmployeeResponse = null;
        if(!dto.getLogin().isEmpty()){
            employee.setLogin(dto.getLogin());
             updateEmployeeResponse =new UpdateEmployeeResponse("Update login complete");
        }
        if(!dto.getAvatar().isEmpty()){
            Avatar avatar=avatarService.CreateEmployee_FindAvatar(dto.getAvatar());
            employee.setAvatar(avatar);
            updateEmployeeResponse =new UpdateEmployeeResponse("Update avatar complete");
        }
        if(!dto.getLogin().isEmpty() & !dto.getLogin().isEmpty()){
             updateEmployeeResponse =new UpdateEmployeeResponse("Update login nd avatar complete");
        }
        employeeRepository.save(employee);
        return updateEmployeeResponse;
    }
    @Override
    public UpdateEmployeeResponse updateEActivityEmployee(@Valid InfoAndUpdateActivityEmployeeRequest dto) {
        Employee employee=employeeRepository.findByLogin(dto.getLogin()).orElseThrow(()->new EmployeeNotFoundException("",HttpStatus.NOT_FOUND));
        Long activity=employee.getActivity()+1;
        employee.setActivity(activity);
        employeeRepository.save(employee);
        return new UpdateEmployeeResponse("Update activity complete");
    }
    @Override
    public InfoEmployeeTopResponse infoTopEmployee(@Valid InfoAndUpdateActivityEmployeeRequest dto) {
        Employee employee=employeeRepository.findByLogin(dto.getLogin()).orElseThrow(()->new EmployeeNotFoundException("",HttpStatus.UNAUTHORIZED));
        List<Employee> employees=employeeRepository.findAllByOrderByActivityDesc();
        InfoEmployeeTopResponse infoEmployeeTopResponse=new InfoEmployeeTopResponse();
        List<InfoEmployeeTopResponse.EmployeeTop> top=infoEmployeeTopResponse.getTop();
        for (int i = 0; i <10; i++) {
            if(i>=employees.toArray().length){
                break;
            }
            InfoEmployeeTopResponse.EmployeeTop employeeTop=new InfoEmployeeTopResponse.EmployeeTop();
            employeeTop.setLogin(employees.get(i).getLogin());
            employeeTop.setAvatar(employees.get(i).getAvatar().getName());
            employeeTop.setActivity(employees.get(i).getActivity());
            top.add(employeeTop);
        }
        infoEmployeeTopResponse.setTop(top);
        return infoEmployeeTopResponse;
    }
}