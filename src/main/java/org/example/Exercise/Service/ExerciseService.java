package org.example.Exercise.Service;

import org.example.Exercise.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ExerciseService {
    Exercise findExercisesByName(String name);
    Page<Exercise> filterExerciseByExperts(String experts, Set<Exercise> agonists, Set<Exercise> items,int page,int size);
}
