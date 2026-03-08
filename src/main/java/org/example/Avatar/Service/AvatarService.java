package org.example.Avatar.Service;

import org.example.Avatar.dto.request.FindNameAvatarRequest;
import org.example.Avatar.dto.response.FindNameAvatarResponse;
import org.springframework.stereotype.Service;

@Service
public interface AvatarService {
    FindNameAvatarResponse findAvatar(FindNameAvatarRequest dto);
}
