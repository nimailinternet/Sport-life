package org.example.Exercise.Service;

import lombok.RequiredArgsConstructor;
import org.example.Exercise.Exceptions.ExerciseNotFoundException;
import org.example.Exercise.Exercise;
import org.example.Exercise.ExerciseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;

    @Override
    @Transactional(readOnly = true)
    public Exercise findExercisesByName(String name) {
        return exerciseRepository.findByName(name).orElseThrow(()->new ExerciseNotFoundException(""));
    }

    @Override
    public List<Exercise> filterExerciseByExperts(String experts, Set<Exercise> agonists, Set<Exercise> items) {
        List<Exercise> exercises=exerciseRepository.findFiltered(agonists,items,experts);
        if(exercises.isEmpty()){
            throw new ExerciseNotFoundException("");
        }
        return exercises;
    }
}
