package org.example.Employee.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RefreshEmployeeTokenRequest {
    private String tokenRefresh;
}
