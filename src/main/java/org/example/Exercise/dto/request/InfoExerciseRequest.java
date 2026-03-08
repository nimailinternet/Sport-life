package org.example.Exercise.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class InfoExerciseRequest {
    @NotNull(message = "")
    @NotBlank(message = "")
    @Valid
    private List<String> males;
    @NotBlank(message = "")
    @NotNull(message = "")
    @Valid
    private List<String> items;

    public List<String> getMales() {
        return males;
    }
}
