package org.example.Male.Service;

import org.example.Exceptions.MaleNotFoundException;
import org.example.Male.Male;
import org.example.Male.MaleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MaleServiceImpl implements MaleService {
    private final MaleRepository maleRepository;

    public MaleServiceImpl(MaleRepository maleRepository) {
        this.maleRepository = maleRepository;

    }

    @Override
    public List<Male> infoExercise_FindMale(List<String> males) {
        List<Male> males1=new ArrayList<>();
        for(String male:males){
            males1.add(maleRepository.findByName(male).orElseThrow(()->new MaleNotFoundException("", HttpStatus.NOT_FOUND)));
        }
        return males1;
    }
    @Override
    public List<String> infoExercise_FindNameMale(Set<Male> males) {
        List<String> names=new ArrayList<>();
        for(Male male:males){
            names.add(male.getName());
        }
        return names;
    }
}
