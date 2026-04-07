package org.example.Calendar.dto;

import org.example.Calendar.Calendar;
import org.example.Calendar.dto.request.CalendarDetailsRequest;
import org.example.Calendar.dto.response.FindCalendarsResponse;
import org.example.Employee.Employee;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CalendarMapper {
    public Calendar toEntity(CalendarDetailsRequest dto, Employee employee){
        DayOfWeek day=DayOfWeek.valueOf(dto.getName());
        LocalDate data= LocalDate.now().with(day);
        LocalDateTime date=LocalDateTime.of(data,dto.getTime());
        return new Calendar(date,employee);
    }
    public FindCalendarsResponse toDto(List<Calendar> calendars){
        FindCalendarsResponse findCalendarsResponse=new FindCalendarsResponse();

        Map<DayOfWeek, List<LocalTime>> times = calendars.stream()
                .collect(Collectors.groupingBy(
                        c -> c.getDate().getDayOfWeek(),
                        Collectors.mapping(c -> c.getDate().toLocalTime(), Collectors.toList())
                ));
        findCalendarsResponse.setMonday(times.get(DayOfWeek.MONDAY));
        findCalendarsResponse.setTuesday(times.get(DayOfWeek.TUESDAY));
        findCalendarsResponse.setWednesday(times.get(DayOfWeek.WEDNESDAY));
        findCalendarsResponse.setThursday(times.get(DayOfWeek.THURSDAY));
        findCalendarsResponse.setFriday(times.get(DayOfWeek.FRIDAY));
        findCalendarsResponse.setSaturday(times.get(DayOfWeek.SATURDAY));
        findCalendarsResponse.setSunday(times.get(DayOfWeek.SUNDAY));

        return findCalendarsResponse;
    }
}
