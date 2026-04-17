package org.example.Agonists.Service;

import lombok.RequiredArgsConstructor;
import org.example.Exercise.Exceptions.ExerciseNotFoundException;
import org.example.Exercise.Exercise;
import org.example.Muscle.Muscle;
import org.example.Agonists.Agonists;
import org.example.Agonists.AgonistsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgonistsServiceImpl implements AgonistsService {
    private final AgonistsRepository agonistsRepository;

    @Override
    @Transactional(readOnly = true)
    public Set<Exercise> getExercises(List<Muscle> muscles) {
        Set<Exercise> exercises =agonistsRepository.findByMuscleIn(muscles);
        if(exercises.isEmpty()){
            throw new ExerciseNotFoundException("","muscle");
        }
        return exercises;
    }
    @Override
    @Transactional(readOnly = true)
    public Map<Exercise, Set<Muscle>> findMuscleByExercise(List<Exercise> exercises) {
        List<Agonists> agonists=agonistsRepository.findByExerciseIn(exercises);
        return  agonists.stream().collect(Collectors.groupingBy(Agonists::getExercise,Collectors.mapping(Agonists::getMuscle,Collectors.toSet())));
    }
}
