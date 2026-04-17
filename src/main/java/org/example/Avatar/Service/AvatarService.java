package org.example.Avatar.Service;

import org.example.Avatar.Avatar;
import org.example.Employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AvatarService {
     Page<Avatar> findAllAvatars(int page,int size);
     Avatar findAvatarByName(String name);

     Map<Employee,String> getAvatarsNames(Map<Employee,Avatar> avatars);
}
