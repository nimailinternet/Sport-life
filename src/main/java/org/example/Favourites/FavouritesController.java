package org.example.Favourites;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Employee.EmployeePrincipal;
import org.example.Favourites.UserCase.CreateFavourites;
import org.example.Favourites.UserCase.DeleteFavourites;
import org.example.Favourites.UserCase.InfoFavourites;
import org.example.Favourites.dto.request.CreateFavouritesRequest;
import org.example.Favourites.dto.request.DeleteFavouritesRequest;
import org.example.Favourites.dto.response.CreateFavouritesResponse;
import org.example.Favourites.dto.response.DeleteFavouritesResponse;
import org.example.Favourites.dto.response.InfoFavouritesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Favourites")
@RequiredArgsConstructor
public class FavouritesController {
    private final InfoFavourites infoFavourites;
    private final CreateFavourites createFavourites;
    private final DeleteFavourites deleteFavourites;

    @PostMapping("/create")
    public ResponseEntity<?> createFavourites(@Valid @RequestBody CreateFavouritesRequest dto, @AuthenticationPrincipal EmployeePrincipal principal){
        CreateFavouritesResponse createFavouritesResponse= createFavourites.createFavourites(dto, principal.getLogin());
        return ResponseEntity.ok(createFavouritesResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteFavourites(@Valid @RequestBody DeleteFavouritesRequest dto,@AuthenticationPrincipal EmployeePrincipal principal){
        DeleteFavouritesResponse DeleteFavouritesResponse = deleteFavourites.deleteFavourites(dto, principal.getLogin());
        return  ResponseEntity.ok(DeleteFavouritesResponse);
    }

    @GetMapping("/info")
    public ResponseEntity<?> infoFavourites(@AuthenticationPrincipal EmployeePrincipal principal){
        InfoFavouritesResponse infoFavouritesResponse= infoFavourites.infoFavourites(principal.getLogin());
        return ResponseEntity.ok(infoFavouritesResponse);
    }
}
