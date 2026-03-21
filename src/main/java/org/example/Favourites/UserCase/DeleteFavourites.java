package org.example.Favourites.UserCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Exercise.Exercise;
import org.example.Exercise.Service.ExerciseService;
import org.example.Favourites.Service.FavouritesService;
import org.example.Favourites.dto.request.DeleteFavouritesRequest;
import org.example.Favourites.dto.response.DeleteFavouritesResponse;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteFavourites {
    private final FavouritesService favouritesService;
    private  final EmployeeService employeeService;
    private final ExerciseService exerciseService;
    @Transactional
    public DeleteFavouritesResponse deleteFavourites(DeleteFavouritesRequest dto,String login){
        Employee  employee=employeeService.findEmployee(login);
        Exercise exercise=exerciseService.findExercise(dto.getName());
        String response=favouritesService.deleteFavourites(employee,exercise);
        return new DeleteFavouritesResponse(response);
    }
}
