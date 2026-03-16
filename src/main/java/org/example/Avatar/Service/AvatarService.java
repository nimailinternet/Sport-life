package org.example.Avatar.Service;

import org.example.Avatar.Avatar;
import org.example.Avatar.dto.response.InfoAvatar;
import org.springframework.stereotype.Service;

@Service
public interface AvatarService {
     Avatar CreateAndUpdateEmployee_FindAvatar(String name);
     String InfoEmployee_FindAvatarName(Avatar avatar);
     InfoAvatar infoAvatar();

}
