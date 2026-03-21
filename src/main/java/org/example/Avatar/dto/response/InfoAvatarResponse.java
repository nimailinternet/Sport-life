package org.example.Avatar.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@AllArgsConstructor
@Data
public class InfoAvatarResponse {
    private List<String> avatars;
}
