package org.example.Favourites.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteFavouritesRequest {
    @NotBlank(message = "")
    private  String name;

    public String getName() {
        return name;

    }
}
