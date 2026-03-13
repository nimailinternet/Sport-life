package org.example.Favourites.Service;

import jakarta.validation.Valid;
import org.example.Exercise.dto.response.InfoExerciseAndInfoFavouritesResponse;
import org.example.Favourites.dto.request.FavouritesCreateAndDeleteAndInfoRequest;
import org.example.Favourites.dto.response.FavouritesDeleteAndCreateResponse;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public interface FavouritesService {
    FavouritesDeleteAndCreateResponse createFavourite(@Valid FavouritesCreateAndDeleteAndInfoRequest dto);
    FavouritesDeleteAndCreateResponse deleteFavourites(@Valid FavouritesCreateAndDeleteAndInfoRequest dto);
    InfoExerciseAndInfoFavouritesResponse infoFavourites(@Valid FavouritesCreateAndDeleteAndInfoRequest dto);
}
