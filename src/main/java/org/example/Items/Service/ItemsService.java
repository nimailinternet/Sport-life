package org.example.Items.Service;

import org.example.Exercise.Exercise;
import org.example.Inventory.Inventory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ItemsService{
    Set<Exercise> infoExercise_FindExercise(List<Inventory> inventories);
    Set<Inventory> infoExerciseAndInfoFavourites_FindInventory(Exercise exercise);
}
