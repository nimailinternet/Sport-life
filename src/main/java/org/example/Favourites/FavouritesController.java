package org.example.Favourites;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Exercise.dto.response.InfoExerciseAndInfoFavouritesResponse;
import org.example.Favourites.Service.FavouritesService;
import org.example.Favourites.dto.request.FavouritesCreateAndDeleteAndInfoRequest;
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
    public ResponseEntity<?> createFavourites(@Valid @RequestBody FavouritesCreateAndDeleteAndInfoRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        CreateFavouritesResponse createFavouritesResponse=favouritesService.createFavourite(dto,login);
        return ResponseEntity.ok(createFavouritesResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteFavourites(@Valid @RequestBody DeleteFavouritesRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        FavouritesDeleteAndCreateResponse favouritesDeleteAndCreateResponse =favouritesService.deleteFavourites(dto,login);
        return  ResponseEntity.ok(favouritesDeleteAndCreateResponse);
    }

    @GetMapping("/info")
    public ResponseEntity<?> infoFavourites(){
        InfoFavouritesRequest infoFavouritesRequest=new InfoFavouritesRequest(SecurityContextHolder.getContext().getAuthentication().getName());
        InfoExerciseAndInfoFavouritesResponse infoExerciseAndInfoFavouritesResponse = favouritesService.infoFavourites(infoFavouritesRequest);
        return ResponseEntity.ok(infoExerciseAndInfoFavouritesResponse);
    }
}
