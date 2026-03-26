package org.example.Calendar.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Calendar.Service.CalendarService;
import org.example.Calendar.dto.request.DeleteCalendarRequest;
import org.example.Calendar.dto.response.DeleteCalendarResponse;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteCalendar {
    private final EmployeeService employeeService;
    private final CalendarService calendarService;
    @Transactional
    public DeleteCalendarResponse deleteCalendar(DeleteCalendarRequest dto){
        Employee employee=employeeService.findEmployee(dto.getLogin());
        String response=calendarService.deleteCalendar(dto.getTime(), dto.getName(),employee);
        return new DeleteCalendarResponse(response);
    }
}
