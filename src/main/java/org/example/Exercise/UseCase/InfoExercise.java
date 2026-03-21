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
import org.example.Male.Service.MaleService;
import org.example.Males.Service.MalesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class InfoExercise {
    private  final EmployeeService employeeService;
    private final MalesService malesService;
    private final InventoryService inventoryService;
    private final ItemsService itemsService;
    private final MaleService maleService;
    private final ExerciseService exerciseService;
    @Transactional
    public InfoExerciseResponse infoExercise(InfoExerciseRequest dto,String login){
        Set<Exercise> males=malesService.infoExercise_FindExercise(maleService.infoExercise_FindMale(dto.getMales()));
        Set<Exercise> items=itemsService.infoExercise_FindExercise(inventoryService.FindInventory(dto.getItems()));
        Employee employee=employeeService.findEmployee(login);
        String experts=employeeService.infoExercise_findExpertsEmployee(employee);
        List<Exercise> exercises=exerciseService.infoExercise(males,items,experts);
        InfoExerciseResponse infoExerciseResponse=new InfoExerciseResponse();
        List<InfoExerciseResponse.ExerciseObject> result=new ArrayList<>();
        for(Exercise exercise:exercises) {
            List<String> male = maleService.FindNameMale(malesService.infoExerciseAndInfoFavourites_FindMale(exercise));
            List<String> item=inventoryService.findInventoryName(itemsService.FindInventory(exercise));
            InfoExerciseResponse.ExerciseObject exerciseObject=new InfoExerciseResponse.ExerciseObject
                    (exercise.getName(),exercise.getVideo(),exercise.getPhoto(),exercise.getDescription(),male,item);
            System.out.println(exerciseObject);
            System.out.println(exercise.getName());
            System.out.println(exercise.getVideo());
            System.out.println(exercise.getPhoto());
            System.out.println(exercise.getDescription());
            result.add(exerciseObject);
            System.out.println(result);
        }
        infoExerciseResponse.setExercises(result);
        return infoExerciseResponse;
    }
}
