package org.example.Avatar.Service;

import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.AvatarRepository;
import org.example.Avatar.Exceptions.AvatarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvatarServiceImpl implements AvatarService {
    private final AvatarRepository avatarRepository;

    @Override
    public Avatar CreateAndUpdateEmployee_FindAvatar(String name) {
        return avatarRepository.findByName(name)
                .orElseThrow(()->new AvatarNotFoundException(""));
    }
    @Override
    public String InfoEmployee_FindAvatarName(Avatar avatar) {
        return avatar.getName();

    }
}
