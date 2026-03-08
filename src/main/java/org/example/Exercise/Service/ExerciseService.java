package org.example.Exercise.Service;

import org.example.Exercise.dto.request.InfoExerciseRequest;
import org.example.Exercise.dto.response.InfoExerciseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExerciseService {
    List<InfoExerciseResponse> infoExercise(InfoExerciseRequest dto);
}
