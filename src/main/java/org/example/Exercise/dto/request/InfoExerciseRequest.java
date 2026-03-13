package org.example.Exercise.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoExerciseRequest {
    @NotBlank(message = "")
    @Valid
    private List<String> males;
    @NotBlank(message = "")
    @Valid
    private List<String> items;
    @Pattern(regexp = "^(?!\\s*$).+",message = "")
    private String login;
}
