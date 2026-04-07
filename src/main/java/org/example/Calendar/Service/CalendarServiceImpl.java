package org.example.Calendar.Service;

import lombok.RequiredArgsConstructor;
import org.example.Calendar.Calendar;
import org.example.Calendar.CalendarRepository;
import org.example.Calendar.dto.response.FindCalendarsResponse;
import org.example.Employee.Employee;
import org.example.Calendar.Exceptions.CalendarFoundException;
import org.example.Calendar.Exceptions.CalendarNotFoundException;
import org.example.Exercise.Exceptions.ExerciseNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {
    private final CalendarRepository calendarRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Calendar> findCalendarsByEmployee(Employee employee) {
        List<Calendar> calendars=calendarRepository.findByEmployee(employee);
        if(calendars.isEmpty()){
            throw new CalendarNotFoundException("");
        }
        return calendars;
    }
    @Override
    @Transactional
    public void createCalendar(Calendar calendar) {
        Calendar calendars=calendarRepository.findByEmployeeAndDate(calendar.getEmployee(),calendar.getDate()).orElse(null);
        if(calendars!=null){
            throw new CalendarFoundException("");
        }
        calendarRepository.save(calendar);
    }
    @Override
    @Transactional
    public void deleteCalendar(Calendar calendar) {
        Calendar calendars=calendarRepository.findByEmployeeAndDate(calendar.getEmployee(),calendar.getDate()).orElseThrow(()->new CalendarNotFoundException(""));
        calendarRepository.delete(calendars);
    }
}