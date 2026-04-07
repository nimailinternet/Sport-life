package org.example.Favourites.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouritesDetailsRequest {
    @NotBlank(message = "")
    private  String name;

    public static class DeleteFavouritesRequest extends FavouritesDetailsRequest{
    }
    public static class CreateFavouritesRequest extends FavouritesDetailsRequest{
    }
}
