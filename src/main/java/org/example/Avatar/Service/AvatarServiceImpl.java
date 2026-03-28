package org.example.Avatar.Service;

import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.AvatarRepository;
import org.example.Avatar.Exceptions.AvatarNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvatarServiceImpl implements AvatarService {
    private final AvatarRepository avatarRepository;

    @Override
    public Avatar findAvatar(String name) {
        return avatarRepository.findByName(name)
                .orElseThrow(()->new AvatarNotFoundException("dfdfdfdfd"));
    }
    @Override
    public String findAvatarName(Avatar avatar) {
        return avatar.getName();

    }

    @Override
    public List<Avatar> infoAvatar() {
        List<Avatar> avatars=avatarRepository.findAll();
        return avatars;
    }

    @Override
    public List<String> findAvatarsNames(List<Avatar> avatars) {
        List<String> names=new ArrayList<>();
        for(Avatar avatar:avatars){
            names.add(avatar.getName());
        }
        return names;
    }
}
