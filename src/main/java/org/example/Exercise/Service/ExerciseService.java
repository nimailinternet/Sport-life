package org.example.Exercise.Service;

import org.example.Exercise.Exercise;
import org.example.Exercise.dto.request.InfoExerciseRequest;
import org.example.Exercise.dto.response.InfoExerciseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExerciseService {
    Exercise createFavourite_findExercise(String name);
    InfoExerciseResponse.ExerciseObject infoFavourites_FindExerciseObject(Exercise exercise, List<String> males, List<String> items);

    InfoExerciseResponse infoExercise(InfoExerciseRequest dto,String login);
}
