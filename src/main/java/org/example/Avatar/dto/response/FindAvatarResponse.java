package org.example.Avatar.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
@AllArgsConstructor
@Data
public class FindAvatarResponse {
    private List<String> names;
    private int page;
    private int size;
    private long totalPage;
}
