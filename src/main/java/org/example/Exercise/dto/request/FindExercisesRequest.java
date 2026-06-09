package org.example.Exercise.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindExercisesRequest {
    @NotEmpty()
    private List<@NotBlank() String> muscles;
    @NotEmpty()
    private List<@NotBlank() String> items;
}
