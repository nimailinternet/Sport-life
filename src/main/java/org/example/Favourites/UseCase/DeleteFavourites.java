package org.example.Favourites.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Employee.EmployeePrincipal;
import org.example.Employee.Service.EmployeeService;
import org.example.Exercise.Exercise;
import org.example.Exercise.Service.ExerciseService;
import org.example.Favourites.Service.FavouritesService;
import org.example.Favourites.dto.request.FavouritesDetailsRequest;
import org.example.Favourites.dto.response.FavouritesDetailsResponse;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteFavourites {
    private final FavouritesService favouritesService;
    private  final EmployeeService employeeService;
    private final ExerciseService exerciseService;

    public FavouritesDetailsResponse.DeleteFavouritesResponse deleteFavourites(FavouritesDetailsRequest.DeleteFavouritesRequest dto, EmployeePrincipal principal){
        Employee  employee=employeeService.findEmployeeByLogin(principal.getLogin());
        Exercise exercise=exerciseService.findExercisesByName(dto.getName());
        favouritesService.deleteFavourites(employee,exercise);
        return new FavouritesDetailsResponse.DeleteFavouritesResponse("Favorite deleted");
    }
}
