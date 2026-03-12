package org.example.Favourites;

import jakarta.validation.Valid;
import org.example.Exercise.dto.response.InfoExerciseResponse;
import org.example.Favourites.Service.FavouritesService;
import org.example.Favourites.dto.request.CreateFavouritesRequest;
import org.example.Favourites.dto.request.DeleteFavouritesRequest;
import org.example.Favourites.dto.request.InfoFavouritesRequest;
import org.example.Favourites.dto.response.CreateFavouritesResponse;
import org.example.Favourites.dto.response.DeleteFavouritesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Favourites")
public class FavouritesController {
    private final FavouritesService favouritesService;
    public FavouritesController(FavouritesService favouritesService) {
        this.favouritesService = favouritesService;

    }

    @PostMapping("/create")
    public ResponseEntity<?> createFavourites(@Valid @RequestBody CreateFavouritesRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        CreateFavouritesResponse createFavouritesResponse=favouritesService.createFavourite(dto,login);
        return ResponseEntity.ok(createFavouritesResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteFavourites(@Valid @RequestBody DeleteFavouritesRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        DeleteFavouritesResponse deleteFavouritesResponse=favouritesService.deleteFavourites(dto,login);
        return  ResponseEntity.ok(deleteFavouritesResponse);
    }

    @GetMapping("/info")
    public ResponseEntity<?> infoFavourites(){
        InfoFavouritesRequest infoFavouritesRequest=new InfoFavouritesRequest(SecurityContextHolder.getContext().getAuthentication().getName());
        InfoExerciseResponse infoExerciseResponse= favouritesService.infoFavourites(infoFavouritesRequest);
        return ResponseEntity.ok(infoExerciseResponse);
    }
}
