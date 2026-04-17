package org.example.Employee.UseCase;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.Employee.dto.request.RefreshEmployeeTokenRequest;
import org.example.Employee.dto.response.RefreshEmployeeTokenResponse;
import org.example.Security.AuthClass;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Data
@Service
public class RefreshEmployeeToken {
    private final AuthClass authClass;
    public RefreshEmployeeTokenResponse refresh(RefreshEmployeeTokenRequest dto){
        String tokenRefresh=dto.getTokenRefresh();
        String login=authClass.getLoginRefresh(tokenRefresh);
        String tokenAccess=authClass.createToken(login);
        return new RefreshEmployeeTokenResponse(tokenAccess);
    }
}
