package org.example.Avatar.Service;

import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.AvatarRepository;
import org.example.Avatar.Exceptions.AvatarNotFoundException;
import org.example.Employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AvatarServiceImpl implements AvatarService {
    private final AvatarRepository avatarRepository;

    @Override
    @Transactional(readOnly = true)
    public Avatar findAvatarByName(String name) {
        return avatarRepository.findByName(name)
                .orElseThrow(()->new AvatarNotFoundException("",""));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Avatar> findAllAvatars(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return avatarRepository.findAll(pageable);
    }

    @Override
    public Map<Employee, String> getAvatarsNames( Map<Employee, Avatar> avatars) {
        return avatars.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,a->a.getValue().getName()));
    }
}
