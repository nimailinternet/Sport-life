package org.example.Male.Service;

import org.example.Male.Male;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface MaleService {
    List<Male> infoExercise_FindMale(List<String> males);
    List<String> infoExerciseAndInfoFavourites_FindNameMale(Set<Male> males);
}
