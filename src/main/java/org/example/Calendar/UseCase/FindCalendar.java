package org.example.Calendar.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Calendar.Calendar;
import org.example.Calendar.Service.CalendarService;
import org.example.Calendar.dto.CalendarMapper;
import org.example.Calendar.dto.response.FindCalendarsResponse;
import org.example.Employee.Employee;
import org.example.Employee.EmployeePrincipal;
import org.example.Employee.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
 public class FindCalendar {
    private  final EmployeeService employeeService;
    private final CalendarService calendarService;
    private final CalendarMapper calendarMapper;

    public FindCalendarsResponse findCalendar(EmployeePrincipal principal){
        Employee employee=employeeService.findEmployeeByLogin(principal.getLogin());
        List<Calendar> calendars=calendarService.findCalendarsByEmployee(employee);
        return calendarMapper.toDto(calendars);
    }
}
