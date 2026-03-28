package org.example.Calendar.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Calendar.Service.CalendarService;
import org.example.Calendar.dto.CalendarMapper;
import org.example.Calendar.dto.request.CreateCalendarRequest;
import org.example.Calendar.dto.response.CreateCalendarResponse;
import org.example.Employee.Service.EmployeeService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreateCalendar {
    private final CalendarService calendarService;
    private final EmployeeService employeeService;
    private final CalendarMapper calendarMapper;
    @Transactional
    public CreateCalendarResponse createCalendar(CreateCalendarRequest dto){
        return calendarMapper.toDto2(calendarService.createCalendar(calendarMapper.toEntity(dto,employeeService.findEmployee(dto.getLogin()))));
    }
}
