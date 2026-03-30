package org.example.Calendar.dto;

import org.example.Calendar.Calendar;
import org.example.Calendar.dto.request.CreateCalendarRequest;
import org.example.Calendar.dto.request.DeleteCalendarRequest;
import org.example.Calendar.dto.response.InfoCalendarResponse;
import org.example.Employee.Employee;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

@Component
public class CalendarMapper {
    public InfoCalendarResponse toInfoDto(Map<DayOfWeek, List<Calendar>> response){
        InfoCalendarResponse infoCalendarResponse=new InfoCalendarResponse();
        infoCalendarResponse.setMonday(response.get(DayOfWeek.MONDAY).stream().map(Calendar::getDate).map(LocalDateTime::toLocalTime).toList());
        infoCalendarResponse.setTuesday(response.get(DayOfWeek.TUESDAY).stream().map(Calendar::getDate).map(LocalDateTime::toLocalTime).toList());
        infoCalendarResponse.setWednesday(response.get(DayOfWeek.WEDNESDAY).stream().map(Calendar::getDate).map(LocalDateTime::toLocalTime).toList());
        infoCalendarResponse.setThursday(response.get(DayOfWeek.THURSDAY).stream().map(Calendar::getDate).map(LocalDateTime::toLocalTime).toList());
        infoCalendarResponse.setFriday(response.get(DayOfWeek.FRIDAY).stream().map(Calendar::getDate).map(LocalDateTime::toLocalTime).toList());
        infoCalendarResponse.setSaturday(response.get(DayOfWeek.SATURDAY).stream().map(Calendar::getDate).map(LocalDateTime::toLocalTime).toList());
        infoCalendarResponse.setSunday(response.get(DayOfWeek.SUNDAY).stream().map(Calendar::getDate).map(LocalDateTime::toLocalTime).toList());
        return infoCalendarResponse;
    }

    public Calendar toCreateEntity(CreateCalendarRequest dto, Employee employee){
        DayOfWeek day=DayOfWeek.valueOf(dto.getName());
        LocalDate date=LocalDate.now().with(day);
        LocalDateTime time=LocalDateTime.of(date,dto.getTime());
       return new Calendar (time,employee);
    }

    public Calendar toDeleteEntity(DeleteCalendarRequest dto, Employee employee){
        DayOfWeek day=DayOfWeek.valueOf(dto.getName());
        LocalDate date=LocalDate.now().with(day);
        LocalDateTime time=LocalDateTime.of(date,dto.getTime());
        return new Calendar (time,employee);
    }
}
