package org.example.Avatar.Service;

import org.example.Avatar.Avatar;
import org.example.Avatar.AvatarRepository;
import org.example.Exceptions.AvatarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AvatarServiceImpl implements AvatarService {
    private final AvatarRepository avatarRepository;

    public AvatarServiceImpl(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;

    }

    @Override
    public Avatar CreateEmployee_FindAvatar(String name) {
        return avatarRepository.findByName(name)
                .orElseThrow(()->new AvatarNotFoundException("", HttpStatus.NOT_FOUND));
    }
    @Override
    public String InfoEmployee_FindAvatarName(Avatar avatar) {
        return avatar.getName();

    }
}
