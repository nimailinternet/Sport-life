package org.example.Exercise.dto;

import org.example.Exercise.Exercise;
import org.example.Exercise.dto.response.FindExercisesResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ExerciseMapper {
    public FindExercisesResponse toDto(Page<Exercise> exercises, Map<Long,List<String>> agonistsMap,Map<Long,List<String>> itemsMap, Map<Long,Boolean> favoritesMap){
        List<FindExercisesResponse.ExerciseObject> exerciseObjects=
                exercises.stream()
                        .map(exercise -> new FindExercisesResponse.ExerciseObject(exercise.getId().toString(),exercise.getVideo(),exercise.getDescription(),exercise.getName(),exercise.getPhoto(),agonistsMap.get(exercise.getId()),itemsMap.get(exercise.getId()),favoritesMap.get(exercise.getId()),exercise.getExperts()))
                        .toList();
        return new FindExercisesResponse(exerciseObjects,exercises.getSize(),exercises.getNumber(),exercises.getTotalPages());
    }
}
