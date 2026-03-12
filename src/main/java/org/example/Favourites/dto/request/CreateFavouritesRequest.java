package org.example.Favourites.dto.request;

import jakarta.validation.constraints.NotBlank;


public class CreateFavouritesRequest {
    @NotBlank(message = "")
    private  String name;

    public String getName() {
        return name;

    }
}
