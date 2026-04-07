package org.example.Muscle.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindMusclesResponse {
    private List<MuscleObject> muscles;
    @NoArgsConstructor
    @Data
    @AllArgsConstructor
    public static class MuscleObject {
        private String name;
        private String photo;
    }
}
