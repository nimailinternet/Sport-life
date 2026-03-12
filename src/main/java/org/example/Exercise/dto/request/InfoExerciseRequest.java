package org.example.Exercise.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class InfoExerciseRequest {
    @NotBlank(message = "")
    @Valid
    private List<String> males;
    @NotBlank(message = "")
    @Valid
    private List<String> items;

    public List<String> getMales() {
        return males;

    }
    public List<String> getItems() {
        return items;

    }
}
