package org.example.Muscle.Service;

import org.example.Muscle.Muscle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface MuscleService {
    Map<Long,List<String>> getMusclesIs(Map<Long,Set<Muscle>> muscles);

    List<Muscle> findMusclesByNames(List<Long> names);
}
