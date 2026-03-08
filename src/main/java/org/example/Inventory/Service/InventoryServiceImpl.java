package org.example.Inventory.Service;

import org.example.Exceptions.InventoryNotFoundException;
import org.example.Inventory.Inventory;
import org.example.Inventory.InventoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<Inventory> infoExercise_FindInventory(List<String> names) {
        List<Inventory> inventories=new ArrayList<>();
        for(String item:names){
            inventories.add(inventoryRepository.findByName(item).orElseThrow(()->new InventoryNotFoundException("", HttpStatus.NOT_FOUND)));
        }
        return inventories;
    }

    @Override
    public List<String> infoExercise_findInventoryName(Set<Inventory> inventories) {
        List<String> names=new ArrayList<>();
        for(Inventory inventory:inventories){
            names.add(inventory.getName());
        }
        return names;
    }
}
