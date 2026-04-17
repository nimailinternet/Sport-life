package org.example.Exercise.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindExercisesResponse {
    private List<ExerciseObject> exercises;
    private int size;
    private int page;
    private int totalPage;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ExerciseObject{
        private String name;
        private String video;
        private String description;
        private String photo;
        private List<String> muscles;
        private List<String> items;
    }
}
