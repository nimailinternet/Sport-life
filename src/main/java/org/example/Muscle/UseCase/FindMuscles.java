package org.example.Muscle.UseCase;

import lombok.RequiredArgsConstructor;
import org.example.Muscle.Service.MuscleService;
import org.example.Muscle.dto.MuscleMapper;
import org.example.Muscle.dto.response.FindMusclesResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindMuscles {
    private final MuscleService muscleService;
    private final MuscleMapper muscleMapper;

    public FindMusclesResponse findMuscles(){
        return muscleMapper.toDto(muscleService.findAllMuscle());
    }
}
