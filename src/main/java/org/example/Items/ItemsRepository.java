package org.example.Items;

import org.example.Exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemsRepository extends JpaRepository<Items,Long> {

    Optional<List<Items>> findByInventory();

    Optional<List<Items>> findByExercise(Exercise exercise);
}
