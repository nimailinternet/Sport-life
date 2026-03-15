package org.example.Exercise;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Exercise.Service.ExerciseService;
import org.example.Exercise.dto.request.InfoExerciseRequest;
import org.example.Exercise.dto.response.InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Exercise")
@RequiredArgsConstructor
public class ExerciseController {
    private  final ExerciseService exerciseService;

    @PostMapping("/info")
    public ResponseEntity<?> infoExercise(@Valid @RequestBody  InfoExerciseRequest dto){
        String login= SecurityContextHolder.getContext().getAuthentication().getName();
        InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse infoExerciseAndInfoFavouritesAndFindExerciseObjectResponse =exerciseService.infoExercise(dto);
        return ResponseEntity.ok(infoExerciseAndInfoFavouritesAndFindExerciseObjectResponse);
    }
}
