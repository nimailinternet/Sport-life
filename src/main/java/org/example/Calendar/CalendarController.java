package org.example.Calendar;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Calendar.Service.CalendarService;
import org.example.Calendar.dto.request.DeleteAndCreateCalendarRequest;
import org.example.Calendar.dto.request.InfoCalendarRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Calendar")
@RequiredArgsConstructor
public class CalendarController {
    private final CalendarService calendarService;

    @GetMapping("/info")
    public ResponseEntity<?> infoCalendar(){
        InfoCalendarRequest infoCalendarRequest=new InfoCalendarRequest(SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.ok(calendarService.infoCalendar(infoCalendarRequest));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCalendar(@Valid @RequestBody DeleteAndCreateCalendarRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        dto.setLogin(login);
        return ResponseEntity.ok(calendarService.createCalendar(dto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCalendar(@Valid @RequestBody DeleteAndCreateCalendarRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(calendarService.deleteCalendar(dto));
    }
}
