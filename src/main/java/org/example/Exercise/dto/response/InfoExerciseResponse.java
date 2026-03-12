package org.example.Exercise.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class InfoExerciseResponse {
    private List<ExerciseObject> exercise;

    public List<ExerciseObject> getExercise() {
        return exercise;

    }

    public void setExercise (List<ExerciseObject> exercise) {
        this.exercise = exercise;

    }


    @Data
    @Builder
    public static class ExerciseObject{
        private String name;
        private String video;
        private String description;
        private String photo;
        private List<String> males;
        private List<String> items;

        public ExerciseObject(String name, String photo, String video, String description, List<String> males, List<String> items) {

        }

        public void setName(String name) {
            this.name = name;

        }

        public String getName() {
            return name;

        }
        public String getPhoto() {
            return photo;

        }
        public String getVideo() {
            return video;

        }
        public String getDescription() {
            return description;

        }
    }
}