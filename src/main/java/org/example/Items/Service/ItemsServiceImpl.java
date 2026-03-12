package org.example.Items.Service;

import org.example.Exceptions.InventoryNotFoundException;
import org.example.Exceptions.ItemsNotFoundException;
import org.example.Exercise.Exercise;
import org.example.Inventory.Inventory;
import org.example.Items.Items;
import org.example.Items.ItemsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ItemsServiceImpl implements ItemsService {
    private  final ItemsRepository itemsRepository;

    public ItemsServiceImpl(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;

    }

    @Override
    public Set<Exercise> infoExercise_FindExercise(List<Inventory> inventories) {
        Set<Exercise> exercises=new HashSet<>();
        List<Items> items;
        for(Inventory inventory:inventories) {
            if (itemsRepository.findByInventory(inventory).isEmpty()) {
                throw new ItemsNotFoundException("", HttpStatus.NOT_FOUND);
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
    public  Set<Inventory> infoExercise_FindInventory(Exercise exercise) {
        List<Items> items;
        if(itemsRepository.findByExercise(exercise).isEmpty()){
            throw new InventoryNotFoundException("",HttpStatus.NOT_FOUND);
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
