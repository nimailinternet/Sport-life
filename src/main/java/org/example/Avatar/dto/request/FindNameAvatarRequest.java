package org.example.Avatar.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FindNameAvatarRequest {
    @NotNull(message = "")
    @NotBlank(message = "")
    private String name;

    public FindNameAvatarRequest(String avatar) {
        this.name=avatar;
    }

    public String getName() {
        return name;
    }
}
