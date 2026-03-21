package org.example.Calendar.Service;

import org.example.Calendar.dto.response.InfoCalendarResponse;
import org.example.Employee.Employee;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalTime;

@Service
@Validated
public interface CalendarService {
    InfoCalendarResponse infoCalendar( Employee employee);
    String createCalendar(LocalTime time,String name, Employee employee);
    String deleteCalendar(LocalTime time,String name, Employee employee);
}
