package org.example.Exercise.Service;

import lombok.RequiredArgsConstructor;
import org.example.Employee.Service.EmployeeService;
import org.example.Exercise.Exceptions.ExerciseNotFoundException;
import org.example.Exercise.Exercise;
import org.example.Exercise.ExerciseRepository;
import org.example.Exercise.dto.request.InfoExerciseRequest;
import org.example.Exercise.dto.response.InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse;
import org.example.Inventory.Service.InventoryService;
import org.example.Items.Service.ItemsService;
import org.example.Male.Service.MaleService;
import org.example.Males.Service.MalesService;
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
        return exerciseRepository.findByName(name).orElseThrow(()->new ExerciseNotFoundException(""));
    }
    @Override
    public InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse.ExerciseObject infoFavourites_FindExerciseObject(Exercise exercise, List<String> males, List<String> items) {
        return new InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse.ExerciseObject(exercise.getName(),exercise.getVideo(),exercise.getPhoto(),exercise.getDescription(),males,items);
    }
    @Override
    public InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse infoExercise(InfoExerciseRequest dto) {
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
            throw new ExerciseNotFoundException("");
        }
        InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse infoExerciseAndInfoFavouritesAndFindExerciseObjectResponse =new InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse();
        List<InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse.ExerciseObject> result= infoExerciseAndInfoFavouritesAndFindExerciseObjectResponse.getExercises();
        for(Exercise exercise:exercises) {
            List<String> males = maleService.infoExerciseAndInfoFavourites_FindNameMale(malesService.infoExerciseAndInfoFavourites_FindMale(exercise));
            List<String> items=inventoryService.infoExerciseAndInfoFavourites_findInventoryName(itemsService.infoExerciseAndInfoFavourites_FindInventory(exercise));
            InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse.ExerciseObject exerciseObject=
                    new InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse.ExerciseObject
                            (exercise.getName(),exercise.getVideo(),exercise.getPhoto(),exercise.getDescription(),males,items);
            result.add(exerciseObject);
        }
        infoExerciseAndInfoFavouritesAndFindExerciseObjectResponse.setExercises(result);
        return infoExerciseAndInfoFavouritesAndFindExerciseObjectResponse;
    }
}
