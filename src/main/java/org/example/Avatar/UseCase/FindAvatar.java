package org.example.Avatar.UseCase;

import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.Service.AvatarService;
import org.example.Avatar.dto.AvatarMapper;
import org.example.Avatar.dto.response.FindAvatarResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAvatar {
    private final AvatarService avatarService;
    private final AvatarMapper avatarMapper;

    public FindAvatarResponse findAvatar(int page,int size){
        Page<Avatar> avatars=avatarService.findAllAvatars(page,size);
        return avatarMapper.toDtoFind(avatars);
    }
}
