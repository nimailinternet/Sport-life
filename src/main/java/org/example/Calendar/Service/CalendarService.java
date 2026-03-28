package org.example.Calendar.Service;

import org.example.Calendar.Calendar;
import org.example.Employee.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
public interface CalendarService {
    Map<Integer, List<LocalTime>> infoCalendar(Employee employee);
    String createCalendar(Calendar calendar);
    String deleteCalendar(Calendar calendar);
}
