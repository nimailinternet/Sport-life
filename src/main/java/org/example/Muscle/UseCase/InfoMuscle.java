package org.example.Muscle.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Muscle.Service.MuscleService;
import org.example.Muscle.dto.response.InfoMuscleResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoMuscle {
    private final MuscleService muscleService;
    @Transactional
    public InfoMuscleResponse infoMuscle(){
        InfoMuscleResponse response=new InfoMuscleResponse();
        response.setResponse(muscleService.infoMuscle());
        return response;
    }
}
