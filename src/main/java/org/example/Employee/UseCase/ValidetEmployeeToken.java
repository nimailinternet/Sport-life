package org.example.Employee.UseCase;

import lombok.RequiredArgsConstructor;
import org.example.Employee.dto.request.ValidetEmployeeTokenRequest;
import org.example.Security.AuthClass;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidetEmployeeToken {
    private final AuthClass authClass;
    public Boolean validet(ValidetEmployeeTokenRequest dto){
        Boolean valid = null;
        if(dto.getType().equals("Refresh")){
            valid=authClass.validetTokenRefresh(dto.getToken());
        }
        if(dto.getType().equals("Access")){
            valid=authClass.validetTokenAccess(dto.getToken());
        }
        return valid;
    }
}
