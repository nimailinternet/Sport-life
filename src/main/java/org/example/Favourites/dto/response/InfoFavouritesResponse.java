package org.example.Favourites.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoFavouritesResponse {
    private List<ExerciseObject> exercises;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ExerciseObject{
        private String name;
        private String video;
        private String description;
        private String photo;
        private List<String> males;
        private List<String> items;
    }
}
