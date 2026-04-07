package org.example.Muscle.Service;

import lombok.RequiredArgsConstructor;
import org.example.Exercise.Exercise;
import org.example.Muscle.Exceptions.MuscleNotFoundException;
import org.example.Muscle.Muscle;
import org.example.Muscle.MuscleRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MuscleServiceImpl implements MuscleService {
    private final MuscleRepository muscleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Muscle> findMusclesByNames(List<String> names) {
        List<Muscle> muscles = muscleRepository.findByNameIn(names);
        if(muscles.isEmpty()){
            throw new MuscleNotFoundException("");
        }
        return muscles;
    }
    @Override
    public Map<Exercise, List<String>> getMusclesNames(Map<Exercise,Set<Muscle>> muscles) {
        return muscles.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, m->m.getValue().stream().map(Muscle::getName).toList()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Muscle> findAllMuscle() {
        return muscleRepository.findAll();
    }
}
