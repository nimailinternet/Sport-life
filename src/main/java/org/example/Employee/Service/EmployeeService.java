package org.example.Employee.Service;

import org.example.Employee.Employee;
import org.example.Employee.dto.request.*;
import org.example.Employee.dto.response.AuthAndCreateEmployeeResponse;
import org.example.Employee.dto.response.InfoEmployeeResponse;
import org.example.Employee.dto.response.InfoEmployeeTopResponse;
import org.example.Employee.dto.response.UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
     String infoExercise_findExpertsEmployee(String login);
     Employee createFavourite_FindEmployee(String login);

     AuthAndCreateEmployeeResponse authEmployee(AuthEmployeeRequest dto);
     AuthAndCreateEmployeeResponse createEmployee(CreateEmployeeRequest dto);
     UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse updateEmployeeExpertise(UpdateEmployeeExpertiseRequest dto,String login);
     InfoEmployeeResponse infoEmployee(InfoEmployeeAndUpdateEmployeeActivityAndInfoEmployeeTopRequest dto);
     UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse updateEmployee(UpdateEmployeeRequest dto);
     UpdateEmployeeAndUpdateEmployeeExpertsAndUpdateEmployeeActivityResponse updateEmployeeActivity(InfoEmployeeAndUpdateEmployeeActivityAndInfoEmployeeTopRequest dto);
     InfoEmployeeTopResponse infoEmployeeTop(InfoEmployeeAndUpdateEmployeeActivityAndInfoEmployeeTopRequest dto);


}
