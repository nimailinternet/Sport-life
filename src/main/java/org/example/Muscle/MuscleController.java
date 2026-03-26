package org.example.Muscle;

import lombok.RequiredArgsConstructor;
import org.example.Muscle.UseCase.InfoMuscle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Muscle")
@RequiredArgsConstructor
public class MuscleController {
    private final InfoMuscle infoCase;
    @GetMapping("/info")
    public ResponseEntity<?> ifoMuscle(){
        return ResponseEntity.ok(infoCase.infoMuscle());
    }
}
