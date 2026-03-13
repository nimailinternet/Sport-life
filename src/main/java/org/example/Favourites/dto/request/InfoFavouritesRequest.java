package org.example.Favourites.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoFavouritesRequest {
    @Pattern(regexp = "^(?!\\s*$).+",message = "")
    private String login;
}
