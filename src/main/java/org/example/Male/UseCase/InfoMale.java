package org.example.Male.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Male.Service.MaleService;
import org.example.Male.dto.response.InfoMaleResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoMale {
    private final MaleService maleService;
    @Transactional
    public InfoMaleResponse infoMale(){
        InfoMaleResponse response=new InfoMaleResponse();
        response.setResponse(maleService.infoMale());
        return response;
    }
}
