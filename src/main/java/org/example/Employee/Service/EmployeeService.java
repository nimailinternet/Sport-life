package org.example.Employee.Service;

import org.example.Employee.dto.request.AuthEmployeeRequest;
import org.example.Employee.dto.request.CreateEmployeeRequest;
import org.example.Employee.dto.response.AuthAndCreateEmployeeResponse;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
     AuthAndCreateEmployeeResponse AuthEmployee(AuthEmployeeRequest dto);
     AuthAndCreateEmployeeResponse CreateEmployee(CreateEmployeeRequest dto);
     String InfoExercise_findExpertiseEmployee(String login);

}
