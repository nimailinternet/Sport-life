package org.example.Favourites.Service;

import org.example.Exercise.dto.response.InfoExerciseResponse;
import org.example.Favourites.dto.request.CreateFavouritesRequest;
import org.example.Favourites.dto.request.DeleteFavouritesRequest;
import org.example.Favourites.dto.request.InfoFavouritesRequest;
import org.example.Favourites.dto.response.CreateFavouritesResponse;
import org.example.Favourites.dto.response.DeleteFavouritesResponse;
import org.springframework.stereotype.Service;

@Service
public interface FavouritesService {
    CreateFavouritesResponse createFavourite(CreateFavouritesRequest dto,String login);
    DeleteFavouritesResponse deleteFavourites(DeleteFavouritesRequest dto,String login);
    InfoExerciseResponse infoFavourites(InfoFavouritesRequest dto);
}
