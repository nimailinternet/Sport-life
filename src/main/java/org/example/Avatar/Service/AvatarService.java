package org.example.Avatar.Service;

import org.example.Avatar.Avatar;
import org.springframework.stereotype.Service;

@Service
public interface AvatarService {
     Avatar CreateEmployee_FindAvatar(String name);
     String InfoEmployeeAndUpdateEmployee_FindAvatarName(Avatar avatar);

}
