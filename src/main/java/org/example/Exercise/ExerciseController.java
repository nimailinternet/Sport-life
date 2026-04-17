package org.example.Exercise;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Employee.EmployeePrincipal;
import org.example.Exercise.UseCase.FindExercises;
import org.example.Exercise.dto.request.FindExercisesRequest;
import org.example.Exercise.dto.response.FindExercisesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Exercise")
@RequiredArgsConstructor
public class ExerciseController {
    private  final FindExercises findExercises;

    @PostMapping("/info")
    public ResponseEntity<?> findExercises(@Valid @RequestBody FindExercisesRequest dto,
                                           @AuthenticationPrincipal EmployeePrincipal principal,
                                           @RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10") int size){
        FindExercisesResponse findExercisesResponse = findExercises.findExercises(dto,principal,page,size);
        return ResponseEntity.ok(findExercisesResponse);
    }
}
