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

@RequiredArgsConstructor
@Service
public class DeleteCalendar {
    private final EmployeeService employeeService;
    private final CalendarService calendarService;
    private final CalendarMapper calendarMapper;

    public CalendarDetailsResponse.DeleteCalendarResponse deleteCalendar(CalendarDetailsRequest.DeleteCalendarRequest dto, EmployeePrincipal principal){
        Employee employee=employeeService.findEmployeeByLogin(principal.getLogin());
        Calendar calendar=calendarMapper.toEntity(dto,employee);
        calendarService.deleteCalendar(calendar);
        return new CalendarDetailsResponse.DeleteCalendarResponse("Calendar delete");
    }
}
