package org.example.Exercise.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
public class InfoExerciseResponse {
    private String name;
    private String video;
    private String description;
    private String photo;
    private List<MalesExerciseResponse> males;
    private List<ItemsExerciseResponse> items;
}
@Data
@Builder
@AllArgsConstructor
class MalesExerciseResponse{
    private String name;
    private String photo;
}
@Data
@Builder
@AllArgsConstructor
class  ItemsExerciseResponse{
    private String name;
    private String photo;
}