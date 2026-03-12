package org.example.Calendar.Service;

import org.example.Calendar.dto.request.CreateCalendarRequest;
import org.example.Calendar.dto.request.DeleteCalendarRequest;
import org.example.Calendar.dto.request.InfoCalendarRequest;
import org.example.Calendar.dto.response.CreateCalendarResponse;
import org.example.Calendar.dto.response.DeleteCalendarResponse;
import org.example.Calendar.dto.response.InfoCalendarResponse;
import org.springframework.stereotype.Service;

@Service
public interface CalendarService {
    InfoCalendarResponse infoCalendar(InfoCalendarRequest dto);
    CreateCalendarResponse createCalendar(CreateCalendarRequest dto,String login);
    DeleteCalendarResponse deleteCalendar(DeleteCalendarRequest dto,String login);
}
