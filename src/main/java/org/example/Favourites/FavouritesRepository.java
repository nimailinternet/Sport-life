package org.example.Favourites;

import org.example.Employee.Employee;
import org.example.Exercise.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FavouritesRepository extends JpaRepository<Favourites,Long> {
    @EntityGraph(attributePaths = {"exercise"})
    Page<Favourites> findByEmployee( Employee employee,Pageable pageable);
    Optional<Favourites> findByEmployeeAndExercise(Employee employee, Exercise exercise);
    boolean existsByEmployeeAndExercise(Employee employee,Exercise exercise);
}
