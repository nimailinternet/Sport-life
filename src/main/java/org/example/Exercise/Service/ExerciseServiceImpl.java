package org.example.Exercise.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.Employee.Service.EmployeeService;
import org.example.Exceptions.ExerciseNotFoundException;
import org.example.Exercise.Exercise;
import org.example.Exercise.dto.request.InfoExerciseRequest;
import org.example.Exercise.dto.response.InfoExerciseResponse;
import org.example.Inventory.InventoryRepository;
import org.example.Inventory.Service.InventoryService;
import org.example.Items.ItemsRepository;
import org.example.Items.Service.ItemsService;
import org.example.Male.Service.MaleService;
import org.example.Males.Service.MalesService;
import org.example.Security.AuthClass;
import org.example.Security.SecurityFilterException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final MaleService maleService;
    private final MalesService malesService;
    private  final InventoryService inventoryService;
    private final ItemsService itemsService;
    private  final EmployeeService employeeService;
    public ExerciseServiceImpl(MaleService maleService, MalesService malesService, InventoryRepository inventoryRepository, ItemsRepository itemsRepository, InventoryService inventoryService, ItemsService itemsService, AuthClass authClass, EmployeeService employeeService) {
        this.maleService = maleService;
        this.malesService = malesService;
        this.inventoryService = inventoryService;
        this.itemsService = itemsService;
        this.employeeService = employeeService;
    }

    @Override
    public InfoExerciseResponse infoExercise(InfoExerciseRequest dto) {
        String login=SecurityContextHolder.getContext().getAuthentication().getName();
        Set<Exercise> exercisesMale=malesService.infoExercise_FindExercise(maleService.infoExercise_FindMale(dto.getMales()));
        Set<Exercise> exercisesInventory=itemsService.infoExercise_FindExercise(inventoryService.infoExercise_FindInventory(dto.getItems()));
        List<Exercise> exercises=new ArrayList<>();
        for(Exercise exercise:exercisesMale) {
            if (exercisesInventory.contains(exercise) & exercise.getExpertise().equals(employeeService.InfoExercise_findExpertiseEmployee(login))) {
                exercises.add(exercise);
            } else {
                continue;
            }
        }
        if(exercises.isEmpty()){
            throw new ExerciseNotFoundException("", HttpStatus.NOT_FOUND);
        }
        InfoExerciseResponse infoExerciseResponse=new InfoExerciseResponse();
        List<InfoExerciseResponse.ExerciseObject> result=infoExerciseResponse.getExercise();
        for(Exercise exercise:exercises) {
            List<String> males = maleService.infoExercise_FindNameMale(malesService.infoExercise_FindMale(exercise));
            List<String> items=inventoryService.infoExercise_findInventoryName(itemsService.infoExercise_FindInventory(exercise));
            InfoExerciseResponse.ExerciseObject exerciseObject=
                    new InfoExerciseResponse.ExerciseObject
                            (exercise.getName(),exercise.getVideo(),exercise.getPhoto(),exercise.getDescription(),males,items);
            result.add(exerciseObject);
        }
        infoExerciseResponse.setExercise(result);
        return infoExerciseResponse;
    }
}
