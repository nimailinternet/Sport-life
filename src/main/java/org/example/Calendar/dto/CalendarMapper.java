package org.example.Calendar.dto;

import org.example.Calendar.Calendar;
import org.example.Calendar.dto.request.CreateCalendarRequest;
import org.example.Calendar.dto.request.DeleteCalendarRequest;
import org.example.Calendar.dto.response.CreateCalendarResponse;
import org.example.Calendar.dto.response.DeleteCalendarResponse;
import org.example.Calendar.dto.response.InfoCalendarResponse;
import org.example.Employee.Employee;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
@Component
public class CalendarMapper {
    public InfoCalendarResponse toInfoDto(Map<Integer, List<LocalTime>> response){
        InfoCalendarResponse infoCalendarResponse=new InfoCalendarResponse();
        infoCalendarResponse.setMonday(response.get(1));
        infoCalendarResponse.setTuesday(response.get(2));
        infoCalendarResponse.setWednesday(response.get(3));
        infoCalendarResponse.setThursday(response.get(4));
        infoCalendarResponse.setFriday(response.get(5));
        infoCalendarResponse.setSaturday(response.get(6));
        infoCalendarResponse.setSunday(response.get(7));
        return infoCalendarResponse;
    }

    public CreateCalendarResponse toCreateDto(String response){
        return new CreateCalendarResponse(response);

    }
    public Calendar toCreateEntity(CreateCalendarRequest dto, Employee employee){
        DayOfWeek day=DayOfWeek.valueOf(dto.getName());
        LocalDate date=LocalDate.now().with(day);
        LocalDateTime time=LocalDateTime.of(date,dto.getTime());
       return new Calendar (time,employee);
    }

    public DeleteCalendarResponse toDeleteDto(String response){
        return new DeleteCalendarResponse(response);
    }
    public Calendar toDeleteEntity(DeleteCalendarRequest dto, Employee employee){
        DayOfWeek day=DayOfWeek.valueOf(dto.getName());
        LocalDate date=LocalDate.now().with(day);
        LocalDateTime time=LocalDateTime.of(date,dto.getTime());
        return new Calendar (time,employee);
    }
}
