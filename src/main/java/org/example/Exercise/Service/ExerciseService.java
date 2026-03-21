package org.example.Exercise.Service;

import org.example.Exercise.Exercise;
import org.example.Favourites.dto.response.InfoFavouritesResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ExerciseService {
    Exercise findExercise(String name);
    InfoFavouritesResponse.ExerciseObject FindExerciseObject(Exercise exercise, List<String> males, List<String> items);
    List<Exercise> infoExercise(Set<Exercise> males,Set<Exercise> items, String experts);
}
