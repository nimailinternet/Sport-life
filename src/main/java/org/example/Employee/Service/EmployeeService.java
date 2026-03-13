package org.example.Employee.Service;

import org.example.Employee.Employee;
import org.example.Employee.dto.request.*;
import org.example.Employee.dto.response.AuthAndCreateEmployeeResponse;
import org.example.Employee.dto.response.InfoEmployeeResponse;
import org.example.Employee.dto.response.InfoEmployeeTopResponse;
import org.example.Employee.dto.response.UpdateEmployeeResponse;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
     String infoExercise_findExpertsEmployee(String login);
     Employee FavouritesCreateDeleteInfoAndCalendarInfoDeleteCreate_FindEmployee(String login);

     AuthAndCreateEmployeeResponse authEmployee(AuthEmployeeRequest dto);
     AuthAndCreateEmployeeResponse createEmployee(CreateEmployeeRequest dto);
     UpdateEmployeeResponse updateExpertsEmployee(UpdateExpertsEmployeeRequest dto);
     InfoEmployeeResponse infoEmployee(InfoAndUpdateActivityEmployeeRequest dto);
     UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest dto);
     UpdateEmployeeResponse updateEActivityEmployee(InfoAndUpdateActivityEmployeeRequest dto);
     InfoEmployeeTopResponse infoTopEmployee(InfoAndUpdateActivityEmployeeRequest dto);


}
