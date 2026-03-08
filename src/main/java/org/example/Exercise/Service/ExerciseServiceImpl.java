package org.example.Exercise.Service;

import org.example.Exercise.Exercise;
import org.example.Exercise.dto.request.InfoExerciseRequest;
import org.example.Exercise.dto.response.InfoExerciseResponse;
import org.example.Male.Service.MaleService;
import org.example.Males.Service.MalesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final MaleService maleService;
    private final MalesService malesService;
    public ExerciseServiceImpl(MaleService maleService, MalesService malesService) {
        this.maleService = maleService;
        this.malesService = malesService;
    }

    @Override
    public List<InfoExerciseResponse> infoExercise(InfoExerciseRequest dto) {
        return null;
    }
}
