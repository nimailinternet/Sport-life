package org.example.Favourites.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Exercise.Exercise;
import org.example.Exercise.Service.ExerciseService;
import org.example.Favourites.Favourites;
import org.example.Favourites.Service.FavouritesService;
import org.example.Favourites.dto.response.InfoFavouritesResponse;
import org.example.Inventory.Service.InventoryService;
import org.example.Items.Service.ItemsService;
import org.example.Muscle.Service.MuscleService;
import org.example.Agonists.Service.AgonistsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InfoFavourites {
    private final EmployeeService employeeService;
    private  final AgonistsService agonistsService;
    private final MuscleService muscleService;
    private final InventoryService inventoryService;
    private final ItemsService itemsService;
    private final FavouritesService favouritesService;
    private final ExerciseService exerciseService;
    @Transactional
    public InfoFavouritesResponse infoFavourites(String login){
        Employee employee=employeeService.findEmployee(login);
        List<Favourites> favourites=favouritesService.infoFavourites(employee);
        InfoFavouritesResponse infoFavouritesResponse=new InfoFavouritesResponse();
        infoFavouritesResponse.setExercises(new ArrayList<>());
        List<InfoFavouritesResponse.ExerciseObject> exerciseObjects=infoFavouritesResponse.getExercises();
        for(Favourites favourite:favourites){
            Exercise exercise=favourite.getExercise();
            List<String> males = muscleService.FindMusclesNames(agonistsService.infoExerciseAndInfoFavourites_FindMuscle(exercise));
            List<String> items=inventoryService.findInventorysNames(itemsService.FindInventorys(exercise));
            InfoFavouritesResponse.ExerciseObject exerciseObject=exerciseService.FindExerciseObject(exercise,males,items);
            exerciseObjects.add(exerciseObject);
        }
        infoFavouritesResponse.setExercises(exerciseObjects);
        return infoFavouritesResponse;
    }
}
