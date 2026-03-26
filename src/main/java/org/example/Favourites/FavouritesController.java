package org.example.Favourites;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Employee.EmployeePrincipal;
import org.example.Favourites.UseCase.CreateFavourites;
import org.example.Favourites.UseCase.DeleteFavourites;
import org.example.Favourites.UseCase.InfoFavourites;
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
        dto.setLogin(principal.getLogin());
        CreateFavouritesResponse createFavouritesResponse= createFavourites.createFavourites(dto);
        return ResponseEntity.ok(createFavouritesResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteFavourites(@Valid @RequestBody DeleteFavouritesRequest dto,@AuthenticationPrincipal EmployeePrincipal principal){
        dto.setLogin(principal.getLogin());
        DeleteFavouritesResponse DeleteFavouritesResponse = deleteFavourites.deleteFavourites(dto);
        return  ResponseEntity.ok(DeleteFavouritesResponse);
    }

    @GetMapping("/info")
    public ResponseEntity<?> infoFavourites(@AuthenticationPrincipal EmployeePrincipal principal){
        InfoFavouritesResponse infoFavouritesResponse= infoFavourites.infoFavourites(principal.getLogin());
        return ResponseEntity.ok(infoFavouritesResponse);
    }
}
