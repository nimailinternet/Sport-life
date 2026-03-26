package org.example.Muscle.Service;

import lombok.RequiredArgsConstructor;
import org.example.Muscle.Exceptions.MuscleNotFoundException;
import org.example.Muscle.Muscle;
import org.example.Muscle.MuscleRepository;
import org.example.Muscle.dto.response.InfoMuscleResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MuscleServiceImpl implements MuscleService {
    private final MuscleRepository muscleRepository;

    @Override
    public List<Muscle> FindMuscles(List<String> males) {
        List<Muscle> males1=new ArrayList<>();
        for(String male:males){
            males1.add(muscleRepository.findByName(male).orElseThrow(()->new MuscleNotFoundException("dfdfdf")));
        }
        return males1;
    }
    @Override
    public List<String> FindMusclesNames(Set<Muscle> muscles) {
        List<String> names=new ArrayList<>();
        for(Muscle muscle : muscles){
            names.add(muscle.getName());
        }
        return names;
    }

    @Override
    public List<InfoMuscleResponse.MaleObject> infoMuscle() {
        List<InfoMuscleResponse.MaleObject> response=new ArrayList<>();
        List<Muscle> muscles = muscleRepository.findAll();
        for(Muscle muscle : muscles){
            InfoMuscleResponse.MaleObject maleObject=new InfoMuscleResponse.MaleObject();
            maleObject.setName(muscle.getName());
            maleObject.setPhoto(muscle.getPhoto());
            response.add(maleObject);
        }
        return response;
    }
}
