package org.example.Agonists;

import jakarta.validation.constraints.Past;
import org.example.Exercise.Exercise;
import org.example.Muscle.Muscle;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AgonistsRepository extends JpaRepository<Agonists,Long> {
    @Query("select a from Agonists a join fetch a.muscle join fetch a.exercise where a.exercise in :exercises")
    List<Agonists> findByExerciseIn(@Param("exercises") List<Exercise> exercises);
    @Query("select  distinct a.exercise from Agonists a  where a.muscle in :muscles")
    Set<Exercise> findByMuscleIn(@Param("muscles") List<Muscle> muscles);
}
