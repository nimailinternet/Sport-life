package org.example.Favourites.Service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Exceptions.FavouritesFound;
import org.example.Exceptions.FavouritesNotFoundException;
import org.example.Exercise.Exercise;
import org.example.Exercise.Service.ExerciseService;
import org.example.Exercise.dto.response.InfoExerciseResponse;
import org.example.Favourites.Favourites;
import org.example.Favourites.FavouritesRepository;
import org.example.Favourites.dto.request.CreateFavouritesRequest;
import org.example.Favourites.dto.request.DeleteFavouritesRequest;
import org.example.Favourites.dto.request.InfoFavouritesRequest;
import org.example.Favourites.dto.response.CreateFavouritesResponse;
import org.example.Favourites.dto.response.DeleteFavouritesResponse;
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
public class FavouritesServiceImpl implements FavouritesService {
    private final EmployeeService employeeService;
    private final ExerciseService exerciseService;
    private final MaleService maleService;
    private final MalesService malesService;
    private final InventoryService inventoryService;
    private final ItemsService itemsService;
    private final FavouritesRepository favouritesRepository;

    public FavouritesServiceImpl(EmployeeService employeeService, ExerciseService exerciseService, MaleService maleService, MalesService malesService, InventoryService inventoryService, ItemsService itemsService, FavouritesRepository favouritesRepository) {
        this.employeeService = employeeService;
        this.exerciseService = exerciseService;
        this.maleService = maleService;
        this.malesService = malesService;
        this.inventoryService = inventoryService;
        this.itemsService = itemsService;
        this.favouritesRepository = favouritesRepository;
    }

    @Override
    public CreateFavouritesResponse createFavourite(CreateFavouritesRequest dto,String login) {
        Employee employee=employeeService.createFavourite_FindEmployee(login);
        Exercise exercise=exerciseService.createFavourite_findExercise(dto.getName());
        if(favouritesRepository.findByExercise(exercise).isEmpty()){
            Favourites favourites=new Favourites(exercise,employee);
            favouritesRepository.save(favourites);
            return new CreateFavouritesResponse("Update");
        }
        for(Favourites favourites:favouritesRepository.findByExercise(exercise)){
            if(favourites.getEmployee().equals(employee)){
                throw new FavouritesFound("",HttpStatus.CONFLICT);
            }
        }
        Favourites favourites=new Favourites(exercise,employee);
        favouritesRepository.save(favourites);
        return new CreateFavouritesResponse("Update");
    }
    @Override
    @Transactional
    public DeleteFavouritesResponse deleteFavourites(DeleteFavouritesRequest dto,String login) {
        Employee employee=employeeService.createFavourite_FindEmployee(login);
        Exercise exercise=exerciseService.createFavourite_findExercise(dto.getName());
        Favourites favourites1 = null;
        if(favouritesRepository.findByEmployee(employee).isEmpty()){
            throw new FavouritesNotFoundException("",HttpStatus.NOT_FOUND);
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
            throw new FavouritesNotFoundException("",HttpStatus.NOT_FOUND);
        }
        favouritesRepository.delete(favourites1);
        return new DeleteFavouritesResponse("Deleted");
    }
    @Override
    public InfoExerciseResponse infoFavourites(@Valid InfoFavouritesRequest dto) {
        Employee employee=employeeService.createFavourite_FindEmployee(dto.getLogin());
        List<Favourites> favourites=favouritesRepository.findByEmployee(employee);
        if(favourites.isEmpty()){
            throw new FavouritesNotFoundException("",HttpStatus.NOT_FOUND);
        }
        InfoExerciseResponse infoExerciseResponse=new InfoExerciseResponse();
        List<InfoExerciseResponse.ExerciseObject> exerciseObjects=infoExerciseResponse.getExercise();
        for(Favourites favourite:favourites){
            Exercise exercise=favourite.getExercise();
            List<String> males = maleService.infoExercise_FindNameMale(malesService.infoExercise_FindMale(exercise));
            List<String> items=inventoryService.infoExercise_findInventoryName(itemsService.infoExercise_FindInventory(exercise));
            InfoExerciseResponse.ExerciseObject exerciseObject=exerciseService.infoFavourites_FindExerciseObject(exercise,males,items);
            exerciseObjects.add(new InfoExerciseResponse.ExerciseObject(exerciseObject.getName(),exerciseObject.getPhoto(),exerciseObject.getVideo(),exerciseObject.getDescription(),males,items));
        }
        infoExerciseResponse.setExercise(exerciseObjects);
        return infoExerciseResponse;
    }
}
