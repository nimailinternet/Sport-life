package org.example.Calendar.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Calendar.Service.CalendarService;
import org.example.Calendar.dto.request.CreateCalendarRequest;
import org.example.Calendar.dto.response.CreateCalendarResponse;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCalendar {
    private final CalendarService calendarService;
    private final EmployeeService employeeService;
    @Transactional
    public CreateCalendarResponse createCalendar(CreateCalendarRequest dto,String login){
        Employee  employee=employeeService.findEmployee(login);
        String response= calendarService.createCalendar(dto.getTime(),dto.getName(), employee);
        return new CreateCalendarResponse(response);
    }
}
