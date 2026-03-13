package org.example.Calendar.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteAndCreateCalendarRequest {
    @NotBlank(message = "")
    private String name;
    @JsonFormat(pattern = "HH:mm")
    @NotNull(message = "")
    private LocalTime time;
    @Pattern(regexp = "^(?!\\s*$).+",message = "")
    private String login;
}
