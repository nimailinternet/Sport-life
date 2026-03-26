package org.example.Exercise.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Exercise.Exercise;
import org.example.Exercise.Service.ExerciseService;
import org.example.Exercise.dto.request.InfoExerciseRequest;
import org.example.Exercise.dto.response.InfoExerciseResponse;
import org.example.Inventory.Service.InventoryService;
import org.example.Items.Service.ItemsService;
import org.example.Muscle.Service.MuscleService;
import org.example.Agonists.Service.AgonistsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class InfoExercise {
    private  final EmployeeService employeeService;
    private final AgonistsService agonistsService;
    private final InventoryService inventoryService;
    private final ItemsService itemsService;
    private final MuscleService muscleService;
    private final ExerciseService exerciseService;
    @Transactional
    public InfoExerciseResponse infoExercise(InfoExerciseRequest dto){
        Set<Exercise> males= agonistsService.infoExercise_FindExercise(muscleService.FindMuscles(dto.getMales()));
        Set<Exercise> items=itemsService.FindExercises(inventoryService.findInventorys(dto.getItems()));
        Employee employee=employeeService.findEmployee(dto.getLogin());
        String experts=employeeService.findEmployeeExpert(employee);
        List<Exercise> exercises=exerciseService.infoExercise(males,items,experts);
        InfoExerciseResponse infoExerciseResponse=new InfoExerciseResponse();
        List<InfoExerciseResponse.ExerciseObject> result=new ArrayList<>();
        for(Exercise exercise:exercises) {
            List<String> male = muscleService.FindMusclesNames(agonistsService.infoExerciseAndInfoFavourites_FindMuscle(exercise));
            List<String> item=inventoryService.findInventorysNames(itemsService.FindInventorys(exercise));
            InfoExerciseResponse.ExerciseObject exerciseObject=new InfoExerciseResponse.ExerciseObject
                    (exercise.getName(),exercise.getVideo(),exercise.getPhoto(),exercise.getDescription(),male,item);
        }
        infoExerciseResponse.setExercises(result);
        return infoExerciseResponse;
    }
}
