package org.example.Calendar.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalendarDetailsRequest {
    @NotBlank(message = "asdsadasdasdasdas")
    private String name;
    @NotNull(message = "asdsadsad")
    private String time;
    public static class CreateCalendarRequest extends CalendarDetailsRequest {
    }
    public static class DeleteCalendarRequest extends CalendarDetailsRequest {
    }
}
