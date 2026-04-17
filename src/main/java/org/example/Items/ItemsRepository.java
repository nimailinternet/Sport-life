package org.example.Items;

import org.example.Exercise.Exercise;
import org.example.Inventory.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Items,Long> {
    @Query("select i from Items i join fetch i.exercise where i.inventory in :inventories")
    List<Items> findByInventoryIn(@Param("inventories") List<Inventory> inventories);
    @Query("select i from Items i join fetch i.inventory where i.exercise in :exercises")
    List<Items> findByExerciseIn(@Param("exercises") List<Exercise> exercises);
}
