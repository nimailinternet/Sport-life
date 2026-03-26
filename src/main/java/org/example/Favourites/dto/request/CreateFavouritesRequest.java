package org.example.Favourites.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFavouritesRequest {
    @NotBlank(message = "")
    private  String name;
    private String login;
}
