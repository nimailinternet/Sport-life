package org.example.Avatar.dto;

import org.example.Avatar.Avatar;
import org.example.Avatar.dto.response.InfoAvatarResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AvatarMapper {
    public InfoAvatarResponse toDto(List<Avatar> avatars){
        List<String> names=new ArrayList<>();
        for(Avatar avatar: avatars){
            names.add(avatar.getName());
        }
        return new InfoAvatarResponse(names);
    }
}
