package org.example.Favourites;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Favourites.UserCase.CreateFavourites;
import org.example.Favourites.UserCase.DeleteFavourites;
import org.example.Favourites.UserCase.InfoFavourites;
import org.example.Favourites.dto.request.CreateFavouritesRequest;
import org.example.Favourites.dto.request.DeleteFavouritesRequest;
import org.example.Favourites.dto.request.InfoFavouritesRequest;
import org.example.Favourites.dto.response.CreateFavouritesResponse;
import org.example.Favourites.dto.response.DeleteFavouritesResponse;
import org.example.Favourites.dto.response.InfoFavouritesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Favourites")
@RequiredArgsConstructor
public class FavouritesController {
    private final InfoFavourites infoFavourites;
    private final CreateFavourites createFavourites;
    private final DeleteFavourites deleteFavourites;

    @PostMapping("/create")
    public ResponseEntity<?> createFavourites(@Valid @RequestBody CreateFavouritesRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        CreateFavouritesResponse createFavouritesResponse= createFavourites.createFavourites(dto,login);
        return ResponseEntity.ok(createFavouritesResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteFavourites(@Valid @RequestBody DeleteFavouritesRequest dto){
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        DeleteFavouritesResponse DeleteFavouritesResponse = deleteFavourites.deleteFavourites(dto,login);
        return  ResponseEntity.ok(DeleteFavouritesResponse);
    }

    @GetMapping("/info")
    public ResponseEntity<?> infoFavourites(){
        InfoFavouritesRequest infoFavouritesRequest=new InfoFavouritesRequest(SecurityContextHolder.getContext().getAuthentication().getName());
        InfoFavouritesResponse infoFavouritesResponse= infoFavourites.infoFavourites(infoFavouritesRequest);
        return ResponseEntity.ok(infoFavouritesResponse);
    }
}
