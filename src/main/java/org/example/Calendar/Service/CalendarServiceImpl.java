package org.example.Calendar.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Calendar.Calendar;
import org.example.Calendar.CalendarRepository;
import org.example.Calendar.dto.CalendarMapper;
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
    public String createCalendar(CalendarMapper.Mapper mapper) {
        DayOfWeek day=DayOfWeek.valueOf(mapper.getName());
        LocalDate date=LocalDate.now().with(day);
        LocalDateTime dateTime=date.atTime(mapper.getTime());
        List<Calendar> calendars=calendarRepository.findByEmployee(mapper.getEmployee());
        boolean calendars1=  calendars.stream().anyMatch(c->c.getDate().equals(dateTime));
        if(calendars1){
            throw new CalendarFoundException("");
        }
        Calendar calendar=new Calendar(dateTime,mapper.getEmployee());
        calendarRepository.save(calendar);
        return "Calendar created";
    }
    @Override
    @Transactional
    public String deleteCalendar(LocalTime time, String name, Employee employee) {
        DayOfWeek day=DayOfWeek.valueOf(name);
        LocalDate date=LocalDate.now().with(day);
        LocalDateTime dateTime=date.atTime(time);
        List<Calendar> calendars=calendarRepository.findByEmployee(employee);
        Calendar calendar1 = null;
        for(Calendar calendar:calendars){
            if(Objects.equals(calendar.getDate(),dateTime)){
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
        return "Calendar "+dateTime+" deleted";
    }
}