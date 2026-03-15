package org.example.Items.Service;

import lombok.RequiredArgsConstructor;
import org.example.Inventory.Exceptions.InventoryNotFoundException;
import org.example.Items.Exceptions.ItemsNotFoundException;
import org.example.Exercise.Exercise;
import org.example.Inventory.Inventory;
import org.example.Items.Items;
import org.example.Items.ItemsRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ItemsServiceImpl implements ItemsService {
    private  final ItemsRepository itemsRepository;

    @Override
    public Set<Exercise> infoExercise_FindExercise(List<Inventory> inventories) {
        Set<Exercise> exercises=new HashSet<>();
        List<Items> items;
        for(Inventory inventory:inventories) {
            if (itemsRepository.findByInventory(inventory).isEmpty()) {
                throw new ItemsNotFoundException("");
            }else{
                items = itemsRepository.findByInventory(inventory);
            }
            for(Items items1:items){
                exercises.add(items1.getExercise());
            }
        }
        return exercises;
    }
    @Override
    public  Set<Inventory> infoExerciseAndInfoFavourites_FindInventory(Exercise exercise) {
        List<Items> items;
        if(itemsRepository.findByExercise(exercise).isEmpty()){
            throw new InventoryNotFoundException("");
        }else {
            items = itemsRepository.findByExercise(exercise);
        }
        Set<Inventory> inventories=new HashSet<>();
        for(Items item:items){
            inventories.add(item.getInventory());
        }
        return inventories;
    }
}
