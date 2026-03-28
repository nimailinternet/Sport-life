package org.example.Calendar.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Calendar.Calendar;
import org.example.Calendar.CalendarRepository;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Calendar.Exceptions.CalendarFoundException;
import org.example.Calendar.Exceptions.CalendarNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
@Validated
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {
    private final CalendarRepository calendarRepository;
    private final EmployeeService employeeService;
    
    @Override
    public Map<Integer, List<LocalTime>> infoCalendar(Employee employee) {
        List<Calendar> calendars=calendarRepository.findByEmployee(employee);
        if(calendars.isEmpty()){
            throw new CalendarNotFoundException("");
        }
        Map<Integer,List<LocalTime>> response=new HashMap<>();
        for (int i = 1; i <8 ; i++) {
            DayOfWeek day=DayOfWeek.of(i);
            List<Calendar> calendarTimes=calendars.stream().filter(c->c.getDate().toLocalDate().equals(LocalDate.now().with(day))).toList();
            List<LocalTime> times=new ArrayList<>();
            for(Calendar calendar:calendarTimes){
                times.add(calendar.getDate().toLocalTime());
            }
            response.put(i,times);
        }
        return response;
    }
    @Override
    public String createCalendar(Calendar calendar) {
        LocalDateTime date=calendar.getDate();
        List<Calendar> calendars=calendarRepository.findByEmployee(calendar.getEmployee());
        boolean calendars1=  calendars.stream().anyMatch(c->c.getDate().equals(date));
        if(calendars1){
            throw new CalendarFoundException("");
        }
        Calendar calendar1=new Calendar(date,calendar.getEmployee());
        calendarRepository.save(calendar1);
        return "Calendar created";
    }
    @Override
    @Transactional
    public String deleteCalendar(Calendar calendar) {
        LocalDateTime date=calendar.getDate();
        List<Calendar> calendars=calendarRepository.findByEmployee(calendar.getEmployee());
        Calendar calendar1 = null;
        for(Calendar calendar2:calendars){
            if(Objects.equals(calendar2.getDate(),date)){
                calendar1=calendar;
                break;
            }else{
                continue;
            }
        }
        if(calendar1==null){
            throw new CalendarNotFoundException("");
        }
        calendarRepository.delete(calendar1);
        return "Calendar "+date+" deleted";
    }
}