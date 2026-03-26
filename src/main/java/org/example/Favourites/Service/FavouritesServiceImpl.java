package org.example.Favourites.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Favourites.Exceptions.FavouritesFoundExceptions;
import org.example.Favourites.Exceptions.FavouritesNotFoundException;
import org.example.Exercise.Exercise;
import org.example.Exercise.Service.ExerciseService;
import org.example.Favourites.Favourites;
import org.example.Favourites.FavouritesRepository;
import org.example.Inventory.Service.InventoryService;
import org.example.Items.Service.ItemsService;
import org.example.Muscle.Service.MuscleService;
import org.example.Agonists.Service.AgonistsService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class FavouritesServiceImpl implements FavouritesService {
    private final EmployeeService employeeService;
    private final ExerciseService exerciseService;
    private final MuscleService muscleService;
    private final AgonistsService agonistsService;
    private final InventoryService inventoryService;
    private final ItemsService itemsService;
    private final FavouritesRepository favouritesRepository;

    @Override
    public String createFavourites(Employee employee, Exercise exercise) {
        List<Favourites> favourites=favouritesRepository.findByExercise(exercise);
        if(favourites.isEmpty()){
            Favourites favourite=new Favourites(exercise,employee);
            favouritesRepository.save(favourite);
            return "created";
        }
        for(Favourites favourite:favourites){
            if(favourite.getEmployee().equals(employee)){
                throw new FavouritesFoundExceptions("");
            }
        }
        Favourites favourite=new Favourites(exercise,employee);
        favouritesRepository.save(favourite);
        return "created";
    }
    @Override
    @Transactional
    public String deleteFavourites(Employee employee,Exercise exercise) {
        Favourites favourites1 = null;
        if(favouritesRepository.findByEmployee(employee).isEmpty()){
            throw new FavouritesNotFoundException("");
        }
        for(Favourites favourites:favouritesRepository.findByEmployee(employee)){
            if(favourites.getExercise().equals(exercise)){
                favourites1=favourites;
                break;
            }else{
                continue;
            }
        }
        if(favourites1==null){
            throw new FavouritesNotFoundException("");
        }
        favouritesRepository.delete(favourites1);
        return "Deleted";
    }
    @Override
    public List<Favourites> infoFavourites(Employee employee) {
        List<Favourites> favourites = favouritesRepository.findByEmployee(employee);
        if (favourites.isEmpty()) {
            throw new FavouritesNotFoundException("");
        }
        return favourites;
    }
}
