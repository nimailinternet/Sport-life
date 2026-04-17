package org.example.Employee.Service;

import org.example.Avatar.Avatar;
import org.example.Employee.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
     String getEmployeeExpert(Employee employee);

     Employee findEmployeeByLogin(String login);
     Employee authEmployee(String login,String password);
     Employee createEmployee(String login,String password);
     void updateEmployeeExpert(String login, String experts);
     void updateEmployee(String login,Employee employee,Avatar avatar);
     void updateEmployeeActivity(String login);
     List<Employee> findTopEmployees();


}
