package org.example.Male;

import lombok.RequiredArgsConstructor;
import org.example.Male.UseCase.InfoMale;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Male")
@RequiredArgsConstructor
public class MaleController {
    private final InfoMale infoCase;
    @GetMapping("/info")
    public ResponseEntity<?> ifoMale(){
        return ResponseEntity.ok(infoCase.infoMale());
    }
}
