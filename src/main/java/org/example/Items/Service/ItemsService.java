package org.example.Items.Service;

import org.example.Exercise.Exercise;
import org.example.Inventory.Inventory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface ItemsService{
    Set<Exercise> findExercisesByInventory(List<Inventory> inventories);
    Map<Exercise,Set<Inventory>> findInventoryByExercise(List<Exercise> exercises);
}
