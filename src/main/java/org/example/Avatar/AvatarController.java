package org.example.Avatar;

import lombok.RequiredArgsConstructor;
import org.example.Avatar.Service.AvatarService;
import org.example.Avatar.UseCase.InfoAvatar;
import org.example.Avatar.dto.response.InfoAvatarResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Avatar")
@RequiredArgsConstructor
public class AvatarController {
    private final InfoAvatar infoAvatar;
    @GetMapping("/info")
    public ResponseEntity<InfoAvatarResponse> infoAvatar(){
        return ResponseEntity.ok(infoAvatar.infoAvatar());
    }
}
