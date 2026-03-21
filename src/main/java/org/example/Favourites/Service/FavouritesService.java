package org.example.Favourites.Service;

import org.example.Employee.Employee;
import org.example.Exercise.Exercise;
import org.example.Favourites.Favourites;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public interface FavouritesService {
    String createFavourite(Employee employee, Exercise exercise);
    String deleteFavourites(Employee employee,Exercise exercise);
    List<Favourites> infoFavourites(Employee employee);
}
