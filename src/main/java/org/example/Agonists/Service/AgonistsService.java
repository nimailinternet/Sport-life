package org.example.Agonists.Service;

import org.example.Exercise.Exercise;
import org.example.Muscle.Muscle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface AgonistsService {
    Set<Exercise> getExercises(List<Muscle> muscles);
    Map<Exercise,Set<Muscle>> findMuscleByExercise(List<Exercise> exercises);
}
