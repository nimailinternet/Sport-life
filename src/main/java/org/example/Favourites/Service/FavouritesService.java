package org.example.Favourites.Service;

import jakarta.validation.Valid;
import org.example.Exercise.dto.response.InfoExerciseAndInfoFavouritesResponse;
import org.example.Favourites.dto.request.FavouritesCreateAndDeleteRequest;
import org.example.Favourites.dto.request.InfoFavouritesRequest;
import org.example.Favourites.dto.response.FavouritesDeleteAndCreateResponse;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public interface FavouritesService {
    FavouritesDeleteAndCreateResponse createFavourite(@Valid FavouritesCreateAndDeleteRequest dto);
    FavouritesDeleteAndCreateResponse deleteFavourites(@Valid FavouritesCreateAndDeleteRequest dto);
    InfoExerciseAndInfoFavouritesResponse infoFavourites(@Valid InfoFavouritesRequest dto);
}
