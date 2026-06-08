package org.example.Favourites.dto;

import lombok.NoArgsConstructor;
import org.example.Exercise.Exercise;
import org.example.Favourites.dto.response.FindFavouritesResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@NoArgsConstructor
public class FavouriteMapper {

    public FindFavouritesResponse toDto(Page<Exercise> exercises, Map<Long,List<String>> agonistsMap, Map<Long,List<String>> itemsMap){
        FindFavouritesResponse findFavouritesResponse=new FindFavouritesResponse();
        findFavouritesResponse.setSize(exercises.getSize());
        findFavouritesResponse.setPage(exercises.getNumber());
        findFavouritesResponse.setTotalPage(exercises.getTotalPages());
        List<FindFavouritesResponse.FavouriteObject> favouritesObjects=exercises.stream().map(e->{
            return new FindFavouritesResponse.FavouriteObject(e.getId().toString(),
                e.getName(),
                e.getVideo(),
                e.getDescription(),
                e.getPhoto(),
                agonistsMap.get(e.getId()),
                itemsMap.get(e.getId()),
                e.getExperts(),
                true
        );}).toList();
        findFavouritesResponse.setExercises(favouritesObjects);
        return findFavouritesResponse;
    }
}
