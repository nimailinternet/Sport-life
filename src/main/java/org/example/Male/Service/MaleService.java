package org.example.Male.Service;

import org.example.Male.Male;
import org.example.Male.dto.response.InfoMaleResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface MaleService {
    List<Male> infoExercise_FindMale(List<String> males);
    List<String> FindNameMale(Set<Male> males);

    List<InfoMaleResponse.MaleObject> infoMale();
}
