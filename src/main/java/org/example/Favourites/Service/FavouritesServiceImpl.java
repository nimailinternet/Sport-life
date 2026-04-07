package org.example.Favourites.Service;

import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Exercise.Exercise;
import org.example.Favourites.Exceptions.FavouritesFoundExceptions;
import org.example.Favourites.Exceptions.FavouritesNotFoundException;
import org.example.Favourites.Favourites;
import org.example.Favourites.FavouritesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavouritesServiceImpl implements FavouritesService {
    private final FavouritesRepository favouritesRepository;
    @Override
    @Transactional
    public void createFavourites(Employee employee, Exercise exercise) {
        boolean presenceFavourites =favouritesRepository.existsByEmployeeAndExercise(employee,exercise);
        if(presenceFavourites) throw new FavouritesFoundExceptions("");
        Favourites favourite=new Favourites(exercise,employee);
        favouritesRepository.save(favourite);
    }
    @Override
    @Transactional
    public void deleteFavourites(Employee employee,Exercise exercise) {
        Favourites favourite = favouritesRepository.findByEmployeeAndExercise(employee,exercise).orElseThrow(()->new FavouritesNotFoundException(""));
        favouritesRepository.delete(favourite);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Exercise> findExerciseByEmployees(Employee employee) {
        List<Favourites> favourites = favouritesRepository.findByEmployee(employee);
        if (favourites.isEmpty()) {
            throw new FavouritesNotFoundException("");
        }
        return favourites.stream().map(Favourites::getExercise).toList();
    }
}
