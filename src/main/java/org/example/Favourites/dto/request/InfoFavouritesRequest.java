package org.example.Favourites.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InfoFavouritesRequest {
    @NotBlank(message = "")
    private String login;

    public InfoFavouritesRequest(String name) {
    }

    public String getLogin() {
        return login;

    }
}
