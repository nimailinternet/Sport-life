package org.example.Calendar.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@Builder
public class DeleteCalendarRequest {
    @NotBlank(message = "")
    private String name;
    @JsonFormat(pattern = "HH:mm")
    @NotNull(message = "")
    private LocalTime time;
}
