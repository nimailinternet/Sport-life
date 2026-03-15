package org.example.Males.Service;

import lombok.RequiredArgsConstructor;
import org.example.Male.Exceptions.MaleNotFoundException;
import org.example.Males.Exceptions.MalesNotFoundException;
import org.example.Exercise.Exercise;
import org.example.Male.Male;
import org.example.Males.Males;
import org.example.Males.MalesRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MalesServiceIMpl implements MalesService {
    private final MalesRepository malesRepository;

    @Override
    public Set<Exercise> infoExercise_FindExercise(List<Male> males) {
        Set<Exercise> exercises=new HashSet<>();
        List<Males> males1;
        for(Male male:males){
            if(malesRepository.findByMale(male).isEmpty()){
                throw new MaleNotFoundException("");
            }else {
                males1 = malesRepository.findByMale(male);
            }
            for(Males males2:males1){
                exercises.add(males2.getExercise());
            }
        }
        return exercises;
    }
    @Override
    public Set<Male> infoExerciseAndInfoFavourites_FindMale(Exercise exercises) {
        Set<Male> males=new HashSet<>();
        List<Males> males1;
        if(malesRepository.findByExercise(exercises).isEmpty()){
            throw new MalesNotFoundException("");
        }else{
            males1=malesRepository.findByExercise(exercises);
        }
        for(Males males2:males1){
            males.add(males2.getMale());
        }
        return males;
    }
}
