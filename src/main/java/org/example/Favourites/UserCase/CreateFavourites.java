package org.example.Favourites.UserCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Exercise.Exercise;
import org.example.Exercise.Service.ExerciseService;
import org.example.Favourites.Service.FavouritesService;
import org.example.Favourites.dto.request.CreateFavouritesRequest;
import org.example.Favourites.dto.response.CreateFavouritesResponse;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateFavourites {
    private final EmployeeService employeeService;
    private final ExerciseService exerciseService;
    private final FavouritesService favouritesService;
    @Transactional
    public CreateFavouritesResponse createFavourites(CreateFavouritesRequest dto,String login){
        Employee employee=employeeService.findEmployee(login);
        Exercise exercise=exerciseService.findExercise(dto.getName());
        String response=favouritesService.createFavourite(employee,exercise);
        return new CreateFavouritesResponse(response);
    }
}
