package org.example.Employee.Service;

import org.example.Avatar.Avatar;
import org.example.Employee.Employee;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

@Service
@Validated
public interface EmployeeService {
     String infoExercise_findExpertsEmployee(Employee employee);
     Employee findEmployee(String login);
     List<Avatar> findAvatars(List<Employee> employees);

     String authEmployee(String login,String password);
     String createEmployee(String login,String password,String avatar);
     String updateExpertsEmployee(String login,String experts);
     String updateEmployee(String login,String login2,Avatar avatar);
     String updateActivityEmployee(String login);
     List<Employee> infoTopEmployee();
     List<Map<String,Object>> infoTopEmployees(List<Employee> employees,List<String> names);


}
