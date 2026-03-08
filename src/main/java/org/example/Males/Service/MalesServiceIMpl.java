package org.example.Males.Service;

import org.example.Exceptions.MaleNotFoundException;
import org.example.Exceptions.MalesNotFoundException;
import org.example.Exercise.Exercise;
import org.example.Male.Male;
import org.example.Males.Males;
import org.example.Males.MalesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MalesServiceIMpl implements MalesService {
    private final MalesRepository malesRepository;

    public MalesServiceIMpl(MalesRepository malesRepository) {
        this.malesRepository = malesRepository;
    }

    @Override
    public Set<Exercise> infoExercise_FindExercise(List<Male> males) {
        Set<Exercise> exercises=new HashSet<>();
        for(Male male:males){
            List<Males> males1 = malesRepository.findByMale(male).orElseThrow(()->new MaleNotFoundException("", HttpStatus.NOT_FOUND));
            for(Males males2:males1){
                exercises.add(males2.getExercise());
            }
        }
        return exercises;
    }

    @Override
    public Set<Male> infoExercise_FindMale(Exercise exercises) {
        Set<Male> males=new HashSet<>();
        List<Males> males1=malesRepository.findByExercise(exercises).orElseThrow(()->new MalesNotFoundException("",HttpStatus.NOT_FOUND));
        for(Males males2:males1){
            males.add(males2.getMale());
        }
        return males;
    }
}
