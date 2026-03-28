package org.example.Calendar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Calendar.dto.request.CreateCalendarRequest;
import org.example.Calendar.dto.response.CreateCalendarResponse;
import org.example.Calendar.dto.response.InfoCalendarResponse;
import org.example.Employee.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
@Component
public class CalendarMapper {
    public InfoCalendarResponse toDto(Map<Integer, List<LocalTime>> response){
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
    public CreateCalendarResponse toDto2(String response){
        return new CreateCalendarResponse(response);

    }

    public Mapper toEntity(CreateCalendarRequest dto,Employee employee){
       return new Mapper (dto.getName(), dto.getTime(),employee);

    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Mapper{
        private String name;
        private LocalTime time;
        private Employee employee;
    }

}
