package org.example.Favourites.UseCase;

import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Employee.EmployeePrincipal;
import org.example.Employee.Service.EmployeeService;
import org.example.Exercise.Exercise;
import org.example.Favourites.Service.FavouritesService;
import org.example.Favourites.dto.FavouriteMapper;
import org.example.Favourites.dto.response.FindFavouritesResponse;
import org.example.Inventory.Service.InventoryService;
import org.example.Items.Service.ItemsService;
import org.example.Muscle.Service.MuscleService;
import org.example.Agonists.Service.AgonistsService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FindFavourites {
    private final EmployeeService employeeService;
    private  final AgonistsService agonistsService;
    private final MuscleService muscleService;
    private final InventoryService inventoryService;
    private final ItemsService itemsService;
    private final FavouritesService favouritesService;
    private final FavouriteMapper favouriteMapper;

    public FindFavouritesResponse findFavourites(EmployeePrincipal principal){
        Employee employee=employeeService.findEmployeeByLogin(principal.getLogin());
        List<Exercise> exercises=favouritesService.findExerciseByEmployees(employee);
        Map<Exercise,List<String>> agonistsMap=muscleService.getMusclesNames(agonistsService.findMuscleByExercise(exercises));
        Map<Exercise,List<String>> itemsMap=inventoryService.getInventoriesNames(itemsService.findInventoryByExercise(exercises));
        return favouriteMapper.toDto(exercises,agonistsMap,itemsMap);
    }
}
