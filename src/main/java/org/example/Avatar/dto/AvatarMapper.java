package org.example.Avatar.dto;

import org.example.Avatar.Avatar;
import org.example.Avatar.dto.response.FindAvatarResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvatarMapper {
    public FindAvatarResponse toDtoFind(List<Avatar> avatars){
        List<String> names=avatars.stream().map(Avatar::getName).toList();
        return new FindAvatarResponse(names);
    }
}
