package org.example.Exercise.Service;

import org.example.Exercise.Exercise;
import org.example.Exercise.dto.request.InfoExerciseRequest;
import org.example.Exercise.dto.response.InfoExerciseAndInfoFavouritesResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExerciseService {
    Exercise FavouritesCreateDelete_findExercise(String name);
    InfoExerciseAndInfoFavouritesResponse.ExerciseObject infoFavourites_FindExerciseObject(Exercise exercise, List<String> males, List<String> items);

    InfoExerciseAndInfoFavouritesResponse infoExercise(InfoExerciseRequest dto);
}
