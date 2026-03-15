package org.example.Employee.Service;

import jakarta.validation.Valid;
import org.example.Employee.Employee;
import org.example.Employee.dto.request.*;
import org.example.Employee.dto.response.AuthAndCreateEmployeeResponse;
import org.example.Employee.dto.response.InfoEmployeeResponse;
import org.example.Employee.dto.response.InfoEmployeeTopResponse;
import org.example.Employee.dto.response.UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public interface EmployeeService {
     String infoExercise_findExpertsEmployee(String login);
     Employee FavouritesCreateDeleteInfoAndCalendarInfoDeleteCreate_FindEmployee(String login);

     AuthAndCreateEmployeeResponse authEmployee(AuthEmployeeRequest dto);
     AuthAndCreateEmployeeResponse createEmployee(CreateEmployeeRequest dto);
     UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse updateExpertsEmployee(UpdateExpertsEmployeeRequest dto);
     InfoEmployeeResponse infoEmployee(@Valid  InfoAndUpdateActivityAndInfoTopEmployeeRequest dto);
     UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse updateEmployee(UpdateEmployeeRequest dto);
     UpdateAndUpdateActivityAndUpdateExpertsEmployeeResponse updateActivityEmployee(@Valid  InfoAndUpdateActivityAndInfoTopEmployeeRequest dto);
     InfoEmployeeTopResponse infoTopEmployee(@Valid  InfoAndUpdateActivityAndInfoTopEmployeeRequest dto);


}
