package org.example.Agonists;

import org.example.Exercise.Exercise;
import org.example.Muscle.Muscle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgonistsRepository extends JpaRepository<Agonists,Long> {
    List<Agonists> findByMuscle(Muscle muscle);
    List<Agonists> findByExercise(Exercise exercise);
}
