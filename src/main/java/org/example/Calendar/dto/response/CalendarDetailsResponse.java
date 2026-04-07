package org.example.Calendar.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalendarDetailsResponse {
    private String message;

    public static class CreateCalendarResponse extends CalendarDetailsResponse{
        public CreateCalendarResponse(String message){
            super(message);
        }
    }
    public static class DeleteCalendarResponse extends CalendarDetailsResponse{
        public DeleteCalendarResponse(String message){
            super(message);
        }
    }
}
