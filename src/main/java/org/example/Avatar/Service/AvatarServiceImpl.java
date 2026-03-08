package org.example.Avatar.Service;

import org.example.Avatar.Avatar;
import org.example.Avatar.AvatarRepository;
import org.example.Avatar.dto.request.FindNameAvatarRequest;
import org.example.Avatar.dto.response.FindNameAvatarResponse;
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
    public FindNameAvatarResponse findAvatar(FindNameAvatarRequest dto) {
        Avatar avatar=avatarRepository.findByName(dto.getName())
                .orElseThrow(()->new AvatarNotFoundException("", HttpStatus.NOT_FOUND));
        return new FindNameAvatarResponse(avatar);
    }
}
