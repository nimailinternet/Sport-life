package org.example.Avatar;

import lombok.RequiredArgsConstructor;
import org.example.Avatar.UseCase.FindAvatar;
import org.example.Avatar.dto.response.FindAvatarResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Avatar")
@RequiredArgsConstructor
public class AvatarController {
    private final FindAvatar findAvatar;
    @GetMapping("/info")
    public ResponseEntity<FindAvatarResponse> findAvatar(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(findAvatar.findAvatar(page,size));
    }
}
