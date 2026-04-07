package org.example.Muscle.Service;

import org.example.Exercise.Exercise;
import org.example.Muscle.Muscle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface MuscleService {
    Map<Exercise,List<String>> getMusclesNames(Map<Exercise,Set<Muscle>> muscles);

    List<Muscle> findMusclesByNames(List<String> names);
    List<Muscle> findAllMuscle();
}
