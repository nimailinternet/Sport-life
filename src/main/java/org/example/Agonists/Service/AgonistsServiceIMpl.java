package org.example.Agonists.Service;

import lombok.RequiredArgsConstructor;
import org.example.Muscle.Exceptions.MuscleNotFoundException;
import org.example.Agonists.Exceptions.AgonistsNotFoundException;
import org.example.Exercise.Exercise;
import org.example.Muscle.Muscle;
import org.example.Agonists.Agonists;
import org.example.Agonists.AgonistsRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AgonistsServiceIMpl implements AgonistsService {
    private final AgonistsRepository agonistsRepository;

    @Override
    public Set<Exercise> infoExercise_FindExercise(List<Muscle> muscles) {
        Set<Exercise> exercises=new HashSet<>();
        List<Agonists> agonists1;
        for(Muscle muscle : muscles){
            if(agonistsRepository.findByMuscle(muscle).isEmpty()){
                throw new MuscleNotFoundException("ererer");
            }else {
                agonists1 = agonistsRepository.findByMuscle(muscle);
            }
            for(Agonists agonists2 : agonists1){
                exercises.add(agonists2.getExercise());
            }
        }
        return exercises;
    }
    @Override
    public Set<Muscle> infoExerciseAndInfoFavourites_FindMuscle(Exercise exercises) {
        Set<Muscle> muscles =new HashSet<>();
        List<Agonists> agonists1;
        if(agonistsRepository.findByExercise(exercises).isEmpty()){
            throw new AgonistsNotFoundException("");
        }else{
            agonists1 = agonistsRepository.findByExercise(exercises);
        }
        for(Agonists agonists2 : agonists1){
            muscles.add(agonists2.getMuscle());
        }
        return muscles;
    }
}
