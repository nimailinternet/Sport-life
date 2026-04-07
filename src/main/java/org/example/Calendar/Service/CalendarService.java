package org.example.Calendar.Service;

import org.example.Calendar.Calendar;
import org.example.Calendar.dto.response.FindCalendarsResponse;
import org.example.Employee.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CalendarService {
    List<Calendar> findCalendarsByEmployee(Employee employee);
    void createCalendar(Calendar calendar);
    void deleteCalendar(Calendar calendar);
}
