package org.example.Avatar.dto.response;

import org.example.Avatar.Avatar;

public class FindNameAvatarResponse {
    private Avatar avatar;

    public FindNameAvatarResponse(Avatar avatar) {
        this.avatar=avatar;
    }

    public Avatar getAvatar() {
        return avatar;
    }
}
