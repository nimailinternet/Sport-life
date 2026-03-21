package org.example.Male.Service;

import lombok.RequiredArgsConstructor;
import org.example.Male.Exceptions.MaleNotFoundException;
import org.example.Male.Male;
import org.example.Male.MaleRepository;
import org.example.Male.dto.response.InfoMaleResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MaleServiceImpl implements MaleService {
    private final MaleRepository maleRepository;

    @Override
    public List<Male> infoExercise_FindMale(List<String> males) {
        List<Male> males1=new ArrayList<>();
        for(String male:males){
            males1.add(maleRepository.findByName(male).orElseThrow(()->new MaleNotFoundException("dfdfdf")));
        }
        return males1;
    }
    @Override
    public List<String> FindNameMale(Set<Male> males) {
        List<String> names=new ArrayList<>();
        for(Male male:males){
            names.add(male.getName());
        }
        return names;
    }

    @Override
    public List<InfoMaleResponse.MaleObject> infoMale() {
        List<InfoMaleResponse.MaleObject> response=new ArrayList<>();
        List<Male> males=maleRepository.findAll();
        for(Male male:males){
            InfoMaleResponse.MaleObject maleObject=new InfoMaleResponse.MaleObject();
            maleObject.setName(male.getName());
            maleObject.setPhoto(male.getPhoto());
            response.add(maleObject);
        }
        return response;
    }
}
