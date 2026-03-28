package org.example.Avatar.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Avatar.Service.AvatarService;
import org.example.Avatar.dto.AvatarMapper;
import org.example.Avatar.dto.response.InfoAvatarResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InfoAvatar {
    private final AvatarService avatarService;
    private final AvatarMapper avatarMapper;
    @Transactional
    public InfoAvatarResponse infoAvatar(){
        return avatarMapper.toDto(avatarService.infoAvatar());
    }
}
