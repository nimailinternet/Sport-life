package org.example.Favourites;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Exercise.dto.response.InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse;
import org.example.Favourites.Service.FavouritesService;
import org.example.Favourites.dto.request.FavouritesCreateAndDeleteRequest;
import org.example.Favourites.dto.request.InfoFavouritesRequest;
import org.example.Favourites.dto.response.FavouritesDeleteAndCreateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Favourites")
@RequiredArgsConstructor
public class FavouritesController {
    private final FavouritesService favouritesService;

    @PostMapping("/create")
    public ResponseEntity<?> createFavourites(@Valid @RequestBody FavouritesCreateAndDeleteRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        dto.setLogin(login);
        FavouritesDeleteAndCreateResponse createFavouritesResponse=favouritesService.createFavourite(dto);
        return ResponseEntity.ok(createFavouritesResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteFavourites(@Valid @RequestBody FavouritesCreateAndDeleteRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        dto.setLogin(login);
        FavouritesDeleteAndCreateResponse favouritesDeleteAndCreateResponse =favouritesService.deleteFavourites(dto);
        return  ResponseEntity.ok(favouritesDeleteAndCreateResponse);
    }

    @GetMapping("/info")
    public ResponseEntity<?> infoFavourites(){
        InfoFavouritesRequest infoFavouritesRequest=new InfoFavouritesRequest(SecurityContextHolder.getContext().getAuthentication().getName());
        InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse infoExerciseAndInfoFavouritesAndFindExerciseObjectResponse = favouritesService.infoFavourites(infoFavouritesRequest);
        return ResponseEntity.ok(infoExerciseAndInfoFavouritesAndFindExerciseObjectResponse);
    }
}
