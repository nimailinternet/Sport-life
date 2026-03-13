package org.example.Exercise.Service;

import lombok.RequiredArgsConstructor;
import org.example.Employee.Service.EmployeeService;
import org.example.Exceptions.ExerciseNotFoundException;
import org.example.Exercise.Exercise;
import org.example.Exercise.ExerciseRepository;
import org.example.Exercise.dto.request.InfoExerciseRequest;
import org.example.Exercise.dto.response.InfoExerciseAndInfoFavouritesResponse;
import org.example.Inventory.Service.InventoryService;
import org.example.Items.Service.ItemsService;
import org.example.Male.Service.MaleService;
import org.example.Males.Service.MalesService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {
    private final MaleService maleService;
    private final MalesService malesService;
    private  final InventoryService inventoryService;
    private final ItemsService itemsService;
    private  final EmployeeService employeeService;
    private final ExerciseRepository exerciseRepository;

    @Override
    public Exercise FavouritesCreateDelete_findExercise(String name) {
        return exerciseRepository.findByName(name).orElseThrow(()->new ExerciseNotFoundException("",HttpStatus.NOT_FOUND));
    }
    @Override
    public InfoExerciseAndInfoFavouritesResponse.ExerciseObject infoFavourites_FindExerciseObject(Exercise exercise, List<String> males, List<String> items) {
        return new InfoExerciseAndInfoFavouritesResponse.ExerciseObject(exercise.getName(),exercise.getVideo(),exercise.getPhoto(),exercise.getDescription(),males,items);
    }
    @Override
    public InfoExerciseAndInfoFavouritesResponse infoExercise(InfoExerciseRequest dto) {
        Set<Exercise> exercisesMale=malesService.infoExercise_FindExercise(maleService.infoExercise_FindMale(dto.getMales()));
        Set<Exercise> exercisesInventory=itemsService.infoExercise_FindExercise(inventoryService.infoExercise_FindInventory(dto.getItems()));
        List<Exercise> exercises=new ArrayList<>();
        for(Exercise exercise:exercisesMale) {
            if (exercisesInventory.contains(exercise) & exercise.getExperts().equals(employeeService.infoExercise_findExpertsEmployee(dto.getLogin()))) {
                exercises.add(exercise);
            } else {
                continue;
            }
        }
        if(exercises.isEmpty()){
            throw new ExerciseNotFoundException("", HttpStatus.NOT_FOUND);
        }
        InfoExerciseAndInfoFavouritesResponse infoExerciseAndInfoFavouritesResponse =new InfoExerciseAndInfoFavouritesResponse();
        List<InfoExerciseAndInfoFavouritesResponse.ExerciseObject> result= infoExerciseAndInfoFavouritesResponse.getExercise();
        for(Exercise exercise:exercises) {
            List<String> males = maleService.infoExerciseAndInfoFavourites_FindNameMale(malesService.infoExerciseAndInfoFavourites_FindMale(exercise));
            List<String> items=inventoryService.infoExerciseAndInfoFavourites_findInventoryName(itemsService.infoExercise_FindInventory(exercise));
            InfoExerciseAndInfoFavouritesResponse.ExerciseObject exerciseObject=
                    new InfoExerciseAndInfoFavouritesResponse.ExerciseObject
                            (exercise.getName(),exercise.getVideo(),exercise.getPhoto(),exercise.getDescription(),males,items);
            result.add(exerciseObject);
        }
        infoExerciseAndInfoFavouritesResponse.setExercise(result);
        return infoExerciseAndInfoFavouritesResponse;
    }
}
