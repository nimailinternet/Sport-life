package org.example.Employee.Service;

import jakarta.validation.Valid;
import org.example.Avatar.Avatar;
import org.example.Avatar.Service.AvatarService;
import org.example.Employee.Employee;
import org.example.Employee.EmployeeRepository;
import org.example.Employee.dto.request.*;
import org.example.Employee.dto.response.AuthAndCreateEmployeeResponse;
import org.example.Employee.dto.response.InfoEmployeeResponse;
import org.example.Employee.dto.response.InfoEmployeeTopResponse;
import org.example.Employee.dto.response.UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse;
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
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private  final AuthClass authClass;
    private final AvatarService avatarService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder, AuthClass authClass, AvatarService avatarService) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
        this.authClass = authClass;
        this.avatarService = avatarService;
    }

    @Override
    public String infoExercise_findExpertsEmployee(String login) {
        Employee employee=employeeRepository.findByLogin(login).orElseThrow(()->new EmployeeNotFoundException("",HttpStatus.UNAUTHORIZED));
        return employee.getExperts();
    }
    @Override
    public Employee createFavourite_FindEmployee(String login) {
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
    public UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse updateEmployeeExpertise(UpdateEmployeeExpertiseRequest dto,String login) {
        Employee employee=employeeRepository.findByLogin(login).orElseThrow(()->new EmployeeNotFoundException("",HttpStatus.UNAUTHORIZED));
        employee.setExperts(dto.getExperts());
        return new UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse("Update");
    }
    @Override
    public InfoEmployeeResponse infoEmployee(@Valid InfoEmployeeAndUpdateEmployeeActivityAndInfoEmployeeTopRequest dto) {
        Employee employee=employeeRepository.findByLogin(dto.getLogin()).orElseThrow(()->new EmployeeNotFoundException("",HttpStatus.NOT_FOUND));
        return new InfoEmployeeResponse(dto.getLogin(),employee.getExperts(),employee.getActivity(),avatarService.InfoEmployee_FindAvatarName(employee.getAvatar()));
    }
    @Override
    public UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse updateEmployee(UpdateEmployeeRequest dto) {
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        Employee employee=employeeRepository.findByLogin(login).orElseThrow(()->new EmployeeNotFoundException("",HttpStatus.NOT_FOUND));
        UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse updateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse = null;
        if(!dto.getLogin().isEmpty()){
            employee.setLogin(dto.getLogin());
             updateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse =new UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse("Update login complete");
        }
        if(!dto.getAvatar().isEmpty()){
            Avatar avatar=avatarService.CreateEmployee_FindAvatar(dto.getAvatar());
            employee.setAvatar(avatar);
            updateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse =new UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse("Update avatar complete");
        }
        if(!dto.getLogin().isEmpty() & !dto.getLogin().isEmpty()){
             updateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse =new UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse("Update login nd avatar complete");
        }
        employeeRepository.save(employee);
        return updateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse;
    }
    @Override
    public UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse updateEmployeeActivity(@Valid InfoEmployeeAndUpdateEmployeeActivityAndInfoEmployeeTopRequest dto) {
        Employee employee=employeeRepository.findByLogin(dto.getLogin()).orElseThrow(()->new EmployeeNotFoundException("",HttpStatus.NOT_FOUND));
        Long activity=employee.getActivity()+1;
        employee.setActivity(activity);
        employeeRepository.save(employee);
        return new UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse("Update activity complete");
    }
    @Override
    public InfoEmployeeTopResponse infoEmployeeTop(@Valid InfoEmployeeAndUpdateEmployeeActivityAndInfoEmployeeTopRequest dto) {
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