package org.example.Inventory.Service;

import org.example.Inventory.Inventory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface InventoryService {
    List<Inventory> infoExercise_FindInventory(List<String> names);
    List<String> infoExerciseAndInfoFavourites_findInventoryName(Set<Inventory> inventories);
}
