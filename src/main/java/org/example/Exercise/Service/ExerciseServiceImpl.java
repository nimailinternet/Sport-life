package org.example.Exercise.Service;

import lombok.RequiredArgsConstructor;
import org.example.Exercise.Exceptions.ExerciseNotFoundException;
import org.example.Exercise.Exercise;
import org.example.Exercise.ExerciseRepository;
import org.example.Favourites.dto.response.InfoFavouritesResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;

    @Override
    public Exercise findExercise(String name) {
        return exerciseRepository.findByName(name).orElseThrow(()->new ExerciseNotFoundException(""));
    }
    @Override
    public InfoFavouritesResponse.ExerciseObject FindExerciseObject(Exercise exercise, List<String> males, List<String> items) {
        return new InfoFavouritesResponse.ExerciseObject(exercise.getName(),exercise.getVideo(),exercise.getPhoto(),exercise.getDescription(),males,items);
    }

    @Override
    public List<Exercise> infoExercise(Set<Exercise>  males,Set<Exercise> items, String experts) {
        List<Exercise> exercises=new ArrayList<>();
        for(Exercise exercise:males) {
            if (items.contains(exercise) & exercise.getExperts().equals(experts)) {
                exercises.add(exercise);
            } else {
                continue;
            }
        }
        if(exercises.isEmpty()){
            throw new ExerciseNotFoundException("dfdfdfd");
        }
        return exercises;
    }
}
