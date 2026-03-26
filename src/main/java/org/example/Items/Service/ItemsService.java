package org.example.Items.Service;

import org.example.Exercise.Exercise;
import org.example.Inventory.Inventory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ItemsService{
    Set<Exercise> FindExercises(List<Inventory> inventories);
    Set<Inventory> FindInventorys(Exercise exercise);
}
