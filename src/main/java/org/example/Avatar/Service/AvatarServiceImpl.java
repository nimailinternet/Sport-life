package org.example.Avatar.Service;

import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.AvatarRepository;
import org.example.Avatar.Exceptions.AvatarNotFoundException;
import org.example.Avatar.dto.response.InfoAvatar;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvatarServiceImpl implements AvatarService {
    private final AvatarRepository avatarRepository;

    @Override
    public Avatar CreateAndUpdateEmployee_FindAvatar(String name) {
        return avatarRepository.findByName(name)
                .orElseThrow(()->new AvatarNotFoundException("dfdfdfdfd"));
    }
    @Override
    public String InfoEmployee_FindAvatarName(Avatar avatar) {
        return avatar.getName();

    }

    @Override
    public InfoAvatar infoAvatar() {
        List<Avatar> avatars=avatarRepository.findAll();
        List<String> names=new ArrayList<>();
        for(Avatar avatar:avatars){
            names.add(avatar.getName());
        }
        return new InfoAvatar(names);
    }
}
