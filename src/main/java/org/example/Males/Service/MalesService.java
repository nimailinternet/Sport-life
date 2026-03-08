package org.example.Males.Service;

import org.example.Exercise.Exercise;
import org.example.Male.Male;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface MalesService {
    Set<Exercise> infoExercise_FindExercise(List<Male> males);
    Set<Male> infoExercise_FindMale(Exercise exercises);
}
