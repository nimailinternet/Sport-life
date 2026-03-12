package org.example.Calendar.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCalendarResponse {
    private String create;

    public CreateCalendarResponse(String create) {
    }
}
