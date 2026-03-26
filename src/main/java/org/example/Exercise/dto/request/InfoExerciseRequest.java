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
public class InfoExerciseRequest {
    @NotEmpty(message = "")
    private List<@NotBlank(message = "") String> males;
    @NotEmpty(message = "")
    private List<@NotBlank(message = "") String> items;
    private String login;
}
