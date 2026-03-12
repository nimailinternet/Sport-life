package org.example.Exercise;

import jakarta.validation.Valid;
import org.example.Exercise.Service.ExerciseService;
import org.example.Exercise.dto.request.InfoExerciseRequest;
import org.example.Exercise.dto.response.InfoExerciseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Exercise")
public class ExerciseController {
    private  final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;

    }

    @PostMapping("/info")
    public ResponseEntity<?> infoExercise(@Valid @RequestBody  InfoExerciseRequest dto){
        String login= SecurityContextHolder.getContext().getAuthentication().getName();
        InfoExerciseResponse infoExerciseResponse=exerciseService.infoExercise(dto,login);
        return ResponseEntity.ok(infoExerciseResponse);
    }
}
