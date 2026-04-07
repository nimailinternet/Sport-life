package org.example.Favourites.dto;

import org.example.Exercise.Exercise;
import org.example.Favourites.dto.response.FindFavouritesResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class FavouriteMapper {
    public FindFavouritesResponse toDto(List<Exercise> exercises, Map<Exercise,List<String>> agonistsMap, Map<Exercise,List<String>> itemsMap){
        FindFavouritesResponse findFavouritesResponse=new FindFavouritesResponse();
        List<FindFavouritesResponse.FavouriteObject> favouritesObjects=exercises.stream().map(e->new FindFavouritesResponse.FavouriteObject(
                e.getName(),
                e.getVideo(),
                e.getDescription(),
                e.getPhoto(),
                agonistsMap.get(e),
                itemsMap.get(e)
        )).toList();
        findFavouritesResponse.setFavourites(favouritesObjects);
        return findFavouritesResponse;
    }
}
