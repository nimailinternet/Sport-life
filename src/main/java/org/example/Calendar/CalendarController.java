package org.example.Calendar;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Calendar.UseCase.CreateCalendar;
import org.example.Calendar.UseCase.DeleteCalendar;
import org.example.Calendar.UseCase.InfoCalendar;
import org.example.Calendar.dto.request.CreateCalendarRequest;
import org.example.Calendar.dto.request.DeleteCalendarRequest;
import org.example.Calendar.dto.response.InfoCalendarResponse;
import org.example.Employee.EmployeePrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Calendar")
@RequiredArgsConstructor
public class CalendarController {
    private  final InfoCalendar infoCase;
    private final CreateCalendar createCalendar;
    private final DeleteCalendar deleteCalendar;

    @GetMapping("/info")
    public ResponseEntity<?> infoCalendar(@AuthenticationPrincipal EmployeePrincipal principal){
        InfoCalendarResponse response=infoCase.infoCalendar(principal.getLogin());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCalendar(@Valid @RequestBody CreateCalendarRequest dto,@AuthenticationPrincipal EmployeePrincipal principal){
        dto.setLogin(principal.getLogin());
        return ResponseEntity.ok(createCalendar.createCalendar(dto));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCalendar(@Valid @RequestBody DeleteCalendarRequest dto,@AuthenticationPrincipal EmployeePrincipal principal){
        dto.setLogin(principal.getLogin());
        return ResponseEntity.ok(deleteCalendar.deleteCalendar(dto));
    }
}
