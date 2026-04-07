package org.example.Calendar.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Calendar.Calendar;
import org.example.Calendar.Service.CalendarService;
import org.example.Calendar.dto.CalendarMapper;
import org.example.Calendar.dto.request.CalendarDetailsRequest;
import org.example.Calendar.dto.response.CalendarDetailsResponse;
import org.example.Employee.Employee;
import org.example.Employee.EmployeePrincipal;
import org.example.Employee.Service.EmployeeService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreateCalendar {
    private final CalendarService calendarService;
    private final EmployeeService employeeService;
    private final CalendarMapper calendarMapper;

    public CalendarDetailsResponse.CreateCalendarResponse createCalendar(CalendarDetailsRequest.CreateCalendarRequest dto, EmployeePrincipal principal){
        Employee  employee=employeeService.findEmployeeByLogin(principal.getLogin());
        Calendar calendar=calendarMapper.toEntity(dto,employee);
        calendarService.createCalendar(calendar);
        return new CalendarDetailsResponse.CreateCalendarResponse("Calendar created");
    }
}
