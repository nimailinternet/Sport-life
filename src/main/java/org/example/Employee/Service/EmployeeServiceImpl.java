package org.example.Employee.Service;

import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Employee.Employee;
import org.example.Employee.EmployeeRepository;
import org.example.Employee.Exceptions.EmployeeFoundException;
import org.example.Employee.Exceptions.ExpertsNotFoundException;
import org.example.Employee.Exceptions.UnauthorizedEmployeeException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String getEmployeeExpert(Employee employee) {
        if(employee.getExperts()==null){
            throw new ExpertsNotFoundException("");
        }
        return employee.getExperts();
    }
    @Override
    @Transactional(readOnly = true)
    public Employee findEmployeeByLogin(String login) {
        return employeeRepository.findWithAvatarByLogin(login).orElseThrow(()->new UnauthorizedEmployeeException("","login"));
    }


    @Override
    @Transactional(readOnly = true)
    public Employee authEmployee(String login, String password) {
        Employee employee=employeeRepository
                .findByLogin(login)
                .orElseThrow(()->new UnauthorizedEmployeeException("","login"));
        if(!passwordEncoder.matches(password,employee.getPassword())){
            throw new UnauthorizedEmployeeException("","login");
        }
        return employee;
    }
    @Override
    @Transactional
    public Employee createEmployee(String login, String password) {
        String password1=passwordEncoder.encode(password);
        if(employeeRepository.findByLogin(login).isPresent()){
            throw new EmployeeFoundException("","login");
        }
        Employee employee=new Employee(login,password1,0L);

        employeeRepository.save(employee);
        return employee;
    }
    @Override
    @Transactional
    public void updateEmployeeExpert(String login, String experts) {
        Employee employee=employeeRepository.findByLogin(login).orElseThrow(()->new UnauthorizedEmployeeException("","login"));
        employee.setExperts(experts);
    }
    @Override
    @Transactional
    public void updateEmployee(String login, Employee employee, Avatar avatar) {
        if(login!=null){
            Employee employee1=employeeRepository.findByLogin(login).orElse(null);
            if(Objects.equals(employee1,employee)){
                throw new EmployeeFoundException("","login");
            }
            if(employee1!=null) {
                throw new EmployeeFoundException("","login");
            }
            employee.setLogin(login);
        }
        if(avatar!=null){
            employee.setAvatar(avatar);
        }
    }
    @Override
    @Transactional
    public void updateEmployeeActivity(String login) {
        Employee employee=employeeRepository.findByLogin(login).orElseThrow(()->new UnauthorizedEmployeeException("","login"));
        employee.setActivity(employee.getActivity()+1);;
    }
    @Override
    @Transactional(readOnly = true)
    public List<Employee> findTopEmployees(){
       return employeeRepository.findAllByOrderByActivityDesc();

    }
}