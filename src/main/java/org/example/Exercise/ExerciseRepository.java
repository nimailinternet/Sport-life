package org.example.Exercise;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise,Long> {
    Optional<Exercise> findByName(String name);
    @Query("select e from Exercise e where e.experts=:experts and e in :agonists and e in :items")
    Page<Exercise> findByFiltered(@Param("agonists") Set<Exercise> agonists, @Param("items") Set<Exercise> items, @Param("experts") String experts, Pageable pageable);
}
