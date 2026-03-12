package org.example.Calendar;

import jakarta.validation.Valid;
import org.example.Calendar.Service.CalendarService;
import org.example.Calendar.dto.request.CreateCalendarRequest;
import org.example.Calendar.dto.request.DeleteCalendarRequest;
import org.example.Calendar.dto.request.InfoCalendarRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Calendar")
public class CalendarController {
    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;


    }

    @GetMapping("/info")
    public ResponseEntity<?> infoCalendar(){
        InfoCalendarRequest infoCalendarRequest=new InfoCalendarRequest(SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.ok(calendarService.infoCalendar(infoCalendarRequest));
    }
    @PostMapping("/create")
    public ResponseEntity<?> createCalendar(@Valid @RequestBody CreateCalendarRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        calendarService.createCalendar(dto,login);
        return ResponseEntity.ok(calendarService.createCalendar(dto,login));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCalendar(@Valid @RequestBody DeleteCalendarRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(calendarService.deleteCalendar(dto,login));
    }
}
