package org.example.Calendar.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Calendar.Service.CalendarService;
import org.example.Calendar.dto.response.InfoCalendarResponse;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
 public class InfoCalendar {
    private  final EmployeeService employeeService;
    private final CalendarService calendarService;
    @Transactional
    public InfoCalendarResponse infoCalendar(String login){
        Employee employee=employeeService.findEmployee(login);
        InfoCalendarResponse response=calendarService.infoCalendar(employee);
        return response;
    }
}
