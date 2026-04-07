package org.example.Muscle;

import lombok.RequiredArgsConstructor;
import org.example.Muscle.UseCase.FindMuscles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Muscle")
@RequiredArgsConstructor
public class MuscleController {
    private final FindMuscles findMuscles;
    @GetMapping("/info")
    public ResponseEntity<?> findMuscles(){
        return ResponseEntity.ok(findMuscles.findMuscles());

    }
}
