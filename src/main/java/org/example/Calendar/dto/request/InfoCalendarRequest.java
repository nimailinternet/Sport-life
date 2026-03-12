package org.example.Calendar.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class InfoCalendarRequest {
    @NotBlank(message = "")
    private String login;
}
