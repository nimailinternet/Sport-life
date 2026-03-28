package org.example.Avatar.Service;

import org.example.Avatar.Avatar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AvatarService {
     Avatar findAvatar(String name);
     String findAvatarName(Avatar avatar);
     List<Avatar> infoAvatar();
     List<String> findAvatarsNames(List<Avatar> avatars);

}
