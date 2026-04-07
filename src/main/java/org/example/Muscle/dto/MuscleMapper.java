package org.example.Muscle.dto;

import org.example.Muscle.Muscle;
import org.example.Muscle.dto.response.FindMusclesResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MuscleMapper {
    public FindMusclesResponse toDto(List<Muscle> muscles){
        return new  FindMusclesResponse(
                muscles.stream().map(m->{
            FindMusclesResponse.MuscleObject muscleObject=new FindMusclesResponse.MuscleObject();
            muscleObject.setName(m.getName());
            muscleObject.setPhoto(m.getPhoto());
            return muscleObject;
        }).toList()
        );
    }
}
