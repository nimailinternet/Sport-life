package org.example.Employee.Service;

import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.Service.AvatarService;
import org.example.Employee.Employee;
import org.example.Employee.EmployeeRepository;
import org.example.Employee.Exceptions.EmployeeFoundException;
import org.example.Employee.Exceptions.EmployeeNotFoundException;
import org.example.Employee.Exceptions.UnauthorizedEmployeeException;
import org.example.Security.AuthClass;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Validated
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private  final AuthClass authClass;
    private final AvatarService avatarService;

    @Override
    public String findEmployeeExpert(Employee employee) {
        return employee.getExperts();
    }
    @Override
    public Employee findEmployee(String login) {
        return employeeRepository.findByLogin(login).orElseThrow(()->new EmployeeNotFoundException("dfdfdf"));
    }

    @Override
    public List<Avatar> findAvatars(List<Employee> employees) {
        List<Avatar> avatars=new ArrayList<>();
        for(Employee employee:employees){
            avatars.add(employee.getAvatar());
        };
        return avatars;
    }


    @Override
    public String authEmployee(String login, String password) {
        Employee employee=employeeRepository
                .findByLogin(login)
                .orElseThrow(()->new EmployeeNotFoundException(""));
        if(!passwordEncoder.matches(password,employee.getPassword())){
            throw new UnauthorizedEmployeeException("");
        }
        return authClass.createToken(login);
    }
    @Override
    public String createEmployee(String login, String password, Avatar avatar) {
        if(employeeRepository.findByLogin(login).isPresent()){
            throw new EmployeeFoundException("");
        }
        Employee employee;
        if(avatar!=null){
            String password1=passwordEncoder.encode(password);
             employee=new Employee(login,avatar,password1,0L);
        }else{
            String password1=passwordEncoder.encode(password);
            employee=new Employee(login,password1,0L);
        }
        employeeRepository.save(employee);
        String token=authClass.createToken(login);
        return token;
    }
    @Override
    public String updateEmployeeExpert(String login, String experts) {
        Employee employee=employeeRepository.findByLogin(login).orElseThrow(()->new EmployeeNotFoundException(""));
        employee.setExperts(experts);
        employeeRepository.save(employee);
        return "Update experts complete";
    }
    @Override
    public String updateEmployee(String login, String login2, Avatar avatar) {
        String s="";
        Employee employee=employeeRepository.findByLogin(login2).orElseThrow(()->new EmployeeNotFoundException("вававава"));
        if(login!=null){
            if(employeeRepository.findByLogin(login).isPresent()){
                throw new EmployeeFoundException("");
            }
            employee.setLogin(login);
            s="login";
        }
        if(avatar!=null){
            employee.setAvatar(avatar);
            s="avatar";
        }
        if(login!=null & avatar!=null){
            s="login and avatar";
        }
        employeeRepository.save(employee);
        return "Update "+s+" complete";
    }
    @Override
    public String updateEmployeeActivity(String login) {
        Employee employee=employeeRepository.findByLogin(login).orElseThrow(()->new EmployeeNotFoundException(""));
        Long activity=employee.getActivity()+1;
        employee.setActivity(activity);
        employeeRepository.save(employee);
        return "Update activity complete";
    }
    @Override
    public List<Employee> infoEmployeeTop(){
       return employeeRepository.findAllByOrderByActivityDesc();

    }
    @Override
    public List<Map<String, Object>> findEmployees(List<Employee> employees, List<String> names) {
        List<Map<String,Object>> response=new ArrayList<>();
        int i=0;
        for (Employee employee:employees) {
            Map<String,Object> result=new LinkedHashMap<>();
            String avatar=names.get(i);
            i+=1;
            result.put("login",employee.getLogin());
            result.put("activity",employee.getActivity());
            result.put("avatar",employee.getAvatar().getName());
            response.add(result);
        }
        return response;
    }
}