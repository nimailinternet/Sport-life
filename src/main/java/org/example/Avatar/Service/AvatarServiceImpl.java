package org.example.Avatar.Service;

import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.AvatarRepository;
import org.example.Exceptions.AvatarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvatarServiceImpl implements AvatarService {
    private final AvatarRepository avatarRepository;

    @Override
    public Avatar CreateEmployee_FindAvatar(String name) {
        return avatarRepository.findByName(name)
                .orElseThrow(()->new AvatarNotFoundException("", HttpStatus.NOT_FOUND));
    }
    @Override
    public String InfoEmployeeAndUpdateEmployee_FindAvatarName(Avatar avatar) {
        return avatar.getName();

    }
}
