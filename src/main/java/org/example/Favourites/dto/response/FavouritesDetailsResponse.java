package org.example.Favourites.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouritesDetailsResponse {
    private String message;


    public static class DeleteFavouritesResponse extends FavouritesDetailsResponse{
        public DeleteFavouritesResponse(String message){
            super(message);
        }
    }

    public static class CreateFavouritesResponse extends FavouritesDetailsResponse{
        public CreateFavouritesResponse(String message){
            super(message);
        }
    }
}
