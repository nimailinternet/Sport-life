package org.example.Muscle.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoMuscleResponse {
    private List<MaleObject> response;
    @NoArgsConstructor
    @Data
    @AllArgsConstructor
    public static class MaleObject{
        private String name;
        private String photo;
    }
}
