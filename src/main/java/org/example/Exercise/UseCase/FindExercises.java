package org.example.Exercise.UseCase;

import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Employee.EmployeePrincipal;
import org.example.Employee.Service.EmployeeService;
import org.example.Exercise.Exercise;
import org.example.Exercise.Service.ExerciseService;
import org.example.Exercise.dto.ExerciseMapper;
import org.example.Exercise.dto.request.FindExercisesRequest;
import org.example.Exercise.dto.response.FindExercisesResponse;
import org.example.Inventory.Service.InventoryService;
import org.example.Items.Service.ItemsService;
import org.example.Muscle.Service.MuscleService;
import org.example.Agonists.Service.AgonistsService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FindExercises {
    private  final EmployeeService employeeService;
    private final AgonistsService agonistsService;
    private final InventoryService inventoryService;
    private final ItemsService itemsService;
    private final MuscleService muscleService;
    private final ExerciseMapper exerciseMapper;
    private final ExerciseService exerciseService;

    public FindExercisesResponse findExercises(FindExercisesRequest dto, EmployeePrincipal principal,int size,int page){
        Set<Exercise> agonists = agonistsService.getExercises(muscleService.findMusclesByNames(dto.getMuscles()));
        Set<Exercise> items=itemsService.findExercisesByInventory(inventoryService.findInventoriesByNames(dto.getItems()));
        Employee employee=employeeService.findEmployeeByLogin(principal.getLogin());
        String experts=employeeService.getEmployeeExpert(employee);
        Page<Exercise> exercises=exerciseService.filterExerciseByExperts(experts,items,agonists,size,page);
        List<Exercise> exercisesList=exercises.getContent();
        Map<Exercise,List<String>> agonistsMap=muscleService.getMusclesNames(agonistsService.findMuscleByExercise(exercisesList));
        Map<Exercise,List<String>> itemsMap=inventoryService.getInventoriesNames(itemsService.findInventoryByExercise(exercisesList));
        return exerciseMapper.toDto(exercises,agonistsMap,itemsMap);
    }
}
