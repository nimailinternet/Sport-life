package org.example.Avatar;

import lombok.RequiredArgsConstructor;
import org.example.Avatar.Service.AvatarService;
import org.example.Avatar.dto.response.InfoAvatar;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Avatar")
@RequiredArgsConstructor
public class AvatarController {
    private final AvatarService avatarService;
    @GetMapping("/info")
    public ResponseEntity<InfoAvatar> infoAvatar(){
        return ResponseEntity.ok(avatarService.infoAvatar());
    }
}
