package org.example.Calendar.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@Builder
public class CreateCalendarRequest {
    @NotBlank(message = "")
    private String name;
    @Future(message = "")
    @JsonFormat(pattern = "HH:mm")
    @NotNull(message = "")
    private LocalTime time;
}
