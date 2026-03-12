package org.example.Calendar.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InfoCalendarRequest {
    @NotBlank(message = "")
    private String login;

    public InfoCalendarRequest(String name) {

    }

    public String getLogin() {
        return login;

    }
}
