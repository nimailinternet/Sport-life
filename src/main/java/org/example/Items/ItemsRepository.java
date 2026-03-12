package org.example.Items;

import org.example.Exercise.Exercise;
import org.example.Inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Items,Long> {
    List<Items> findByInventory(Inventory inventory);
    List<Items> findByExercise(Exercise exercise);
}
