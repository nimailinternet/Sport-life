package org.example.Calendar.Service;

import org.example.Calendar.dto.CalendarMapper;
import org.example.Employee.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
public interface CalendarService {
    Map<Integer, List<LocalTime>> infoCalendar(Employee employee);
    String createCalendar(CalendarMapper.Mapper mapper);
    String deleteCalendar(LocalTime time,String name, Employee employee);
}
