package org.example.Favourites;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Employee.EmployeePrincipal;
import org.example.Favourites.UseCase.CreateFavourites;
import org.example.Favourites.UseCase.DeleteFavourites;
import org.example.Favourites.UseCase.FindFavourites;
import org.example.Favourites.dto.request.FavouritesDetailsRequest;
import org.example.Favourites.dto.response.FavouritesDetailsResponse;
import org.example.Favourites.dto.response.FindFavouritesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Favourites")
@RequiredArgsConstructor
public class FavouritesController {
    private final FindFavourites findFavourites;
    private final CreateFavourites createFavourites;
    private final DeleteFavourites deleteFavourites;

    @PostMapping("/create")
    public ResponseEntity<?> createFavourites(@Valid @RequestBody FavouritesDetailsRequest.CreateFavouritesRequest dto, @AuthenticationPrincipal EmployeePrincipal principal){
        FavouritesDetailsResponse.CreateFavouritesResponse createFavouritesResponse= createFavourites.createFavourites(dto,principal);
        return ResponseEntity.ok(createFavouritesResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteFavourites(@Valid @RequestBody FavouritesDetailsRequest.DeleteFavouritesRequest dto, @AuthenticationPrincipal EmployeePrincipal principal){
        FavouritesDetailsResponse.DeleteFavouritesResponse DeleteFavouritesResponse = deleteFavourites.deleteFavourites(dto,principal);
        return  ResponseEntity.ok(DeleteFavouritesResponse);
    }

    @GetMapping("/info")
    public ResponseEntity<?> findFavourites(@AuthenticationPrincipal EmployeePrincipal principal,@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10")int size){
        FindFavouritesResponse findFavouritesResponse = findFavourites.findFavourites(principal,page,size);
        return ResponseEntity.ok(findFavouritesResponse);
    }
}
