package org.example.Exercise.dto;

import org.example.Exercise.Exercise;
import org.example.Exercise.dto.response.FindExercisesResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ExerciseMapper {
    public FindExercisesResponse toDto(List<Exercise> exercises, Map<Exercise,List<String>> agonistsMap, Map<Exercise,List<String>> itemsMap){
        return new FindExercisesResponse(
                exercises.stream()
                        .map(exercise -> new FindExercisesResponse.ExerciseObject(
                                exercise.getName(),
                                exercise.getVideo(),
                                exercise.getPhoto(),
                                exercise.getDescription(),
                                agonistsMap.get(exercise),
                                itemsMap.get(exercise)
                        ))
                        .toList());

    }
}
