package org.example.Avatar.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Avatar.Service.AvatarService;
import org.example.Avatar.dto.response.InfoAvatarResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoAvatar {
    private final AvatarService avatarService;
    @Transactional
    public InfoAvatarResponse infoAvatar(){
        return new InfoAvatarResponse(avatarService.findAvatarsNames(avatarService.infoAvatar()));
    }
}
