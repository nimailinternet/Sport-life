package org.example.Avatar.Service;

import org.example.Avatar.Avatar;
import org.springframework.stereotype.Service;

@Service
public interface AvatarService {
     Avatar CreateAndUpdateEmployee_FindAvatar(String name);
     String InfoEmployee_FindAvatarName(Avatar avatar);

}
