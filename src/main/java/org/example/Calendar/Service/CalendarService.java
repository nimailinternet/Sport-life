package org.example.Calendar.Service;

import org.example.Calendar.dto.request.DeleteAndCreateCalendarRequest;
import org.example.Calendar.dto.request.InfoCalendarRequest;
import org.example.Calendar.dto.response.DeleteAndCreateCalendarResponse;
import org.example.Calendar.dto.response.InfoCalendarResponse;
import org.springframework.stereotype.Service;

@Service
public interface CalendarService {
    InfoCalendarResponse infoCalendar(InfoCalendarRequest dto);
    DeleteAndCreateCalendarResponse createCalendar(DeleteAndCreateCalendarRequest dto);
    DeleteAndCreateCalendarResponse deleteCalendar(DeleteAndCreateCalendarRequest dto);
}
