package org.example.Favourites.Service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Favourites.Exceptions.FavouritesFoundExceptions;
import org.example.Favourites.Exceptions.FavouritesNotFoundException;
import org.example.Exercise.Exercise;
import org.example.Exercise.Service.ExerciseService;
import org.example.Exercise.dto.response.InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse;
import org.example.Favourites.Favourites;
import org.example.Favourites.FavouritesRepository;
import org.example.Favourites.dto.request.FavouritesCreateAndDeleteRequest;
import org.example.Favourites.dto.request.InfoFavouritesRequest;
import org.example.Favourites.dto.response.FavouritesDeleteAndCreateResponse;
import org.example.Inventory.Service.InventoryService;
import org.example.Items.Service.ItemsService;
import org.example.Male.Service.MaleService;
import org.example.Males.Service.MalesService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class FavouritesServiceImpl implements FavouritesService {
    private final EmployeeService employeeService;
    private final ExerciseService exerciseService;
    private final MaleService maleService;
    private final MalesService malesService;
    private final InventoryService inventoryService;
    private final ItemsService itemsService;
    private final FavouritesRepository favouritesRepository;

    @Override
    public FavouritesDeleteAndCreateResponse createFavourite(@Valid FavouritesCreateAndDeleteRequest dto) {
        Employee employee=employeeService.FavouritesCreateDeleteInfoAndCalendarInfoDeleteCreate_FindEmployee(dto.getLogin());
        Exercise exercise=exerciseService.FavouritesCreateDelete_findExercise(dto.getName());
        if(favouritesRepository.findByExercise(exercise).isEmpty()){
            Favourites favourites=new Favourites(exercise,employee);
            favouritesRepository.save(favourites);
            return new FavouritesDeleteAndCreateResponse("Update");
        }
        for(Favourites favourites:favouritesRepository.findByExercise(exercise)){
            if(favourites.getEmployee().equals(employee)){
                throw new FavouritesFoundExceptions("");
            }
        }
        Favourites favourites=new Favourites(exercise,employee);
        favouritesRepository.save(favourites);
        return new FavouritesDeleteAndCreateResponse("Update");
    }
    @Override
    @Transactional
    public FavouritesDeleteAndCreateResponse deleteFavourites(@Valid FavouritesCreateAndDeleteRequest dto) {
        Employee employee=employeeService.FavouritesCreateDeleteInfoAndCalendarInfoDeleteCreate_FindEmployee(dto.getLogin());
        Exercise exercise=exerciseService.FavouritesCreateDelete_findExercise(dto.getName());
        Favourites favourites1 = null;
        if(favouritesRepository.findByEmployee(employee).isEmpty()){
            throw new FavouritesNotFoundException("");
        }
        for(Favourites favourites:favouritesRepository.findByEmployee(employee)){
            if(favourites.getExercise().equals(exercise)){
                favourites1=favourites;
                break;
            }else{
                continue;
            }
        }
        if(favourites1==null){
            throw new FavouritesNotFoundException("");
        }
        favouritesRepository.delete(favourites1);
        return new FavouritesDeleteAndCreateResponse("Deleted");
    }
    @Override
    public InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse infoFavourites(@Valid InfoFavouritesRequest dto) {
        Employee employee=employeeService.FavouritesCreateDeleteInfoAndCalendarInfoDeleteCreate_FindEmployee(dto.getLogin());
        List<Favourites> favourites=favouritesRepository.findByEmployee(employee);
        if(favourites.isEmpty()){
            throw new FavouritesNotFoundException("");
        }
        InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse infoExerciseAndInfoFavouritesAndFindExerciseObjectResponse =new InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse();
        List<InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse.ExerciseObject> exerciseObjects= infoExerciseAndInfoFavouritesAndFindExerciseObjectResponse.getExercises();
        for(Favourites favourite:favourites){
            Exercise exercise=favourite.getExercise();
            List<String> males = maleService.infoExerciseAndInfoFavourites_FindNameMale(malesService.infoExerciseAndInfoFavourites_FindMale(exercise));
            List<String> items=inventoryService.infoExerciseAndInfoFavourites_findInventoryName(itemsService.infoExerciseAndInfoFavourites_FindInventory(exercise));
            InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse.ExerciseObject exerciseObject=exerciseService.infoFavourites_FindExerciseObject(exercise,males,items);
            exerciseObjects.add(new InfoExerciseAndInfoFavouritesAndFindExerciseObjectResponse.ExerciseObject(exerciseObject.getName(),exerciseObject.getPhoto(),exerciseObject.getVideo(),exerciseObject.getDescription(),males,items));
        }
        infoExerciseAndInfoFavouritesAndFindExerciseObjectResponse.setExercises(exerciseObjects);
        return infoExerciseAndInfoFavouritesAndFindExerciseObjectResponse;
    }
}
