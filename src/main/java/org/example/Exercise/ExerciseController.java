package org.example.Exercise;

import jakarta.validation.Valid;
import org.example.Exercise.Service.ExerciseService;
import org.example.Exercise.dto.request.InfoExerciseRequest;
import org.example.Exercise.dto.response.InfoExerciseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Exercise")
public class ExerciseController {
    private  final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/info")
    public ResponseEntity<?> infoExercise(@Valid InfoExerciseRequest dto){
        InfoExerciseResponse infoExerciseResponse=exerciseService.infoExercise(dto);
        return ResponseEntity.ok(infoExerciseResponse);
    }
}
