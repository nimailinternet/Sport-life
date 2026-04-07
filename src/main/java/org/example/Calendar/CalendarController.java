package org.example.Calendar;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Calendar.UseCase.CreateCalendar;
import org.example.Calendar.UseCase.DeleteCalendar;
import org.example.Calendar.UseCase.FindCalendar;
import org.example.Calendar.dto.request.CalendarDetailsRequest;
import org.example.Calendar.dto.response.FindCalendarsResponse;
import org.example.Employee.EmployeePrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Calendar")
@RequiredArgsConstructor
public class CalendarController {
    private  final FindCalendar infoCase;
    private final CreateCalendar createCalendar;
    private final DeleteCalendar deleteCalendar;

    @GetMapping("/info")
    public ResponseEntity<?> findCalendar(@AuthenticationPrincipal EmployeePrincipal principal){
        FindCalendarsResponse response=infoCase.findCalendar(principal);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCalendar(@Valid @RequestBody CalendarDetailsRequest.CreateCalendarRequest dto, @AuthenticationPrincipal EmployeePrincipal principal){
        return ResponseEntity.ok(createCalendar.createCalendar(dto,principal));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCalendar(@Valid @RequestBody CalendarDetailsRequest.DeleteCalendarRequest dto, @AuthenticationPrincipal EmployeePrincipal principal){
        return ResponseEntity.ok(deleteCalendar.deleteCalendar(dto,principal));
    }
}
