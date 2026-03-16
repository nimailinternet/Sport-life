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
import org.example.Employee.dto.response.UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse;
import org.example.Employee.Exceptions.EmployeeFoundException;
import org.example.Employee.Exceptions.EmployeeNotFoundException;
import org.example.Employee.Exceptions.UnauthorizedEmployeeException;
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
        Employee employee=employeeRepository.findByLogin(login).orElseThrow(()->new EmployeeNotFoundException(""));
        return employee.getExperts();
    }
    @Override
    public Employee FavouritesCreateDeleteInfoAndCalendarInfoDeleteCreate_FindEmployee(String login) {
        return employeeRepository.findByLogin(login).orElseThrow(()->new EmployeeNotFoundException(""));
    }


    @Override
    public AuthAndCreateEmployeeResponse authEmployee(AuthEmployeeRequest dto) {
        Employee employee=employeeRepository
                .findByLogin(dto.getLogin())
                .orElseThrow(()->new EmployeeNotFoundException(""));
        if(!passwordEncoder.matches(dto.getPassword(),employee.getPassword())){
            throw new UnauthorizedEmployeeException("");
        }
        String token=authClass.createToken(dto.getLogin());
        return new AuthAndCreateEmployeeResponse(token);
    }
    @Override
    public AuthAndCreateEmployeeResponse createEmployee(CreateEmployeeRequest dto) {
        if(employeeRepository.findByLogin(dto.getLogin()).isPresent()){
            throw new EmployeeFoundException("");
        }
        Employee employee;
        if(dto.getAvatar()!=null){
            Avatar avatar=avatarService.CreateAndUpdateEmployee_FindAvatar(dto.getAvatar());
            String password=passwordEncoder.encode(dto.getPassword());
             employee=new Employee(dto.getLogin(),avatar,password,0L);
        }else{
            String password=passwordEncoder.encode(dto.getPassword());
            employee=new Employee(dto.getLogin(),password,0L);
        }
        if(dto.getActivity()!=null){
            employee.setActivity(dto.getActivity());
        }
        employeeRepository.save(employee);
        String token=authClass.createToken(dto.getLogin());
        return new AuthAndCreateEmployeeResponse(token);
    }
    @Override
    public UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse updateExpertsEmployee(UpdateExpertsEmployeeRequest dto) {
        Employee employee=employeeRepository.findByLogin(dto.getLogin()).orElseThrow(()->new EmployeeNotFoundException(""));
        employee.setExperts(dto.getExperts());
        return new UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse("Update");
    }
    @Override
    public InfoEmployeeResponse infoEmployee(@Valid InfoAndUpdateActivityAndInfoTopEmployeeRequest dto) {
        Employee employee=employeeRepository.findByLogin(dto.getLogin()).orElseThrow(()->new EmployeeNotFoundException(""));
        return new InfoEmployeeResponse(dto.getLogin(),
                avatarService.InfoEmployee_FindAvatarName(employee.getAvatar()),
                employee.getExperts(),
                employee.getActivity());
    }
    @Override
    public UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse updateEmployee(UpdateEmployeeRequest dto) {
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        Employee employee=employeeRepository.findByLogin(login).orElseThrow(()->new EmployeeNotFoundException(""));
        UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse updateAndUpdateActivityAndUpdateExpertsEmployeeResponse = null;
        if(!dto.getLogin().isEmpty()){
            employee.setLogin(dto.getLogin());
             updateAndUpdateActivityAndUpdateExpertsEmployeeResponse =new UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse("Update login complete");
        }
        if(!dto.getAvatar().isEmpty()){
            Avatar avatar=avatarService.CreateAndUpdateEmployee_FindAvatar(dto.getAvatar());
            employee.setAvatar(avatar);
            updateAndUpdateActivityAndUpdateExpertsEmployeeResponse =new UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse("Update avatar complete");
        }
        if(!dto.getLogin().isEmpty() & !dto.getLogin().isEmpty()){
             updateAndUpdateActivityAndUpdateExpertsEmployeeResponse =new UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse("Update login nd avatar complete");
        }
        employeeRepository.save(employee);
        return updateAndUpdateActivityAndUpdateExpertsEmployeeResponse;
    }
    @Override
    public UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse updateActivityEmployee(@Valid InfoAndUpdateActivityAndInfoTopEmployeeRequest dto) {
        Employee employee=employeeRepository.findByLogin(dto.getLogin()).orElseThrow(()->new EmployeeNotFoundException(""));
        Long activity=employee.getActivity()+1;
        employee.setActivity(activity);
        employeeRepository.save(employee);
        return new UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse("Update activity complete");
    }
    @Override
    public InfoEmployeeTopResponse infoTopEmployee(@Valid InfoAndUpdateActivityAndInfoTopEmployeeRequest dto) {
        Employee employee=employeeRepository.findByLogin(dto.getLogin()).orElseThrow(()->new EmployeeNotFoundException(""));
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