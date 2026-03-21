package org.example.Male.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoMaleResponse {
    private List<MaleObject> response;
    @NoArgsConstructor
    @Data
    public static class MaleObject{
        private String name;
        private String photo;
    }
}
