package org.example.Muscle.Service;

import lombok.RequiredArgsConstructor;
import org.example.Muscle.Exceptions.MuscleNotFoundException;
import org.example.Muscle.Muscle;
import org.example.Muscle.MuscleRepository;
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
    public List<Muscle> findMusclesByNames(List<Long> names) {
        List<Muscle> muscles = muscleRepository.findByIdIn(names);
        if(muscles.isEmpty()){
            throw new MuscleNotFoundException("такие мышцы не найдены","result");
        }
        return muscles;
    }
    @Override
    public Map<Long, List<String>> getMusclesIs(Map<Long, Set<Muscle>> muscles) {
        return muscles.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, m->m.getValue().stream().map(muscle->{
            return muscle.getId().toString();
        }).toList()));
    }
}
