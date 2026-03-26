package org.example.Muscle.Service;

import org.example.Muscle.Muscle;
import org.example.Muscle.dto.response.InfoMuscleResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface MuscleService {
    List<Muscle> FindMuscles(List<String> males);
    List<String> FindMusclesNames(Set<Muscle> muscles);

    List<InfoMuscleResponse.MaleObject> infoMuscle();
}
