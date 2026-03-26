package org.example.Agonists.Service;

import org.example.Exercise.Exercise;
import org.example.Muscle.Muscle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface AgonistsService {
    Set<Exercise> infoExercise_FindExercise(List<Muscle> muscles);
    Set<Muscle> infoExerciseAndInfoFavourites_FindMuscle(Exercise exercises);
}
