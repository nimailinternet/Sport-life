package org.example.Favourites.UserCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Exercise.Exercise;
import org.example.Exercise.Service.ExerciseService;
import org.example.Favourites.Favourites;
import org.example.Favourites.Service.FavouritesService;
import org.example.Favourites.dto.request.InfoFavouritesRequest;
import org.example.Favourites.dto.response.InfoFavouritesResponse;
import org.example.Inventory.Service.InventoryService;
import org.example.Items.Service.ItemsService;
import org.example.Male.Service.MaleService;
import org.example.Males.Service.MalesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InfoFavourites {
    private final EmployeeService employeeService;
    private  final MalesService malesService;
    private final MaleService maleService;
    private final InventoryService inventoryService;
    private final ItemsService itemsService;
    private final FavouritesService favouritesService;
    private final ExerciseService exerciseService;
    @Transactional
    public InfoFavouritesResponse infoFavourites(InfoFavouritesRequest dto){
        Employee employee=employeeService.findEmployee(dto.getLogin());
        List<Favourites> favourites=favouritesService.infoFavourites(employee);
        InfoFavouritesResponse infoFavouritesResponse=new InfoFavouritesResponse();
        infoFavouritesResponse.setExercises(new ArrayList<>());
        List<InfoFavouritesResponse.ExerciseObject> exerciseObjects=infoFavouritesResponse.getExercises();
        for(Favourites favourite:favourites){
            Exercise exercise=favourite.getExercise();
            List<String> males = maleService.FindNameMale(malesService.infoExerciseAndInfoFavourites_FindMale(exercise));
            List<String> items=inventoryService.findInventoryName(itemsService.FindInventory(exercise));
            InfoFavouritesResponse.ExerciseObject exerciseObject=exerciseService.FindExerciseObject(exercise,males,items);
            exerciseObjects.add(exerciseObject);
        }
        infoFavouritesResponse.setExercises(exerciseObjects);
        return infoFavouritesResponse;
    }
}
