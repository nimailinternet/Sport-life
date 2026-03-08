package org.example.Males;

import org.example.Exercise.Exercise;
import org.example.Male.Male;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface MalesRepository extends JpaRepository<Males,Long> {
    Optional<List<Males>> findByMale(Male male);

    Optional<List<Males>> findByExercise(Exercise exercise);
}
