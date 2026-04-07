package org.example.Favourites.Service;

import org.example.Employee.Employee;
import org.example.Exercise.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavouritesService {
    void createFavourites(Employee employee, Exercise exercise);
    void deleteFavourites(Employee employee,Exercise exercise);
    List<Exercise> findExerciseByEmployees(Employee employee);
}
