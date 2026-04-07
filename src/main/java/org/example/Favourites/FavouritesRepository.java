package org.example.Favourites;

import org.example.Employee.Employee;
import org.example.Exercise.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavouritesRepository extends JpaRepository<Favourites,Long> {
    @Query("select f from Favourites f join fetch f.exercise where f.employee =:employee")
    List<Favourites> findByEmployee(@Param("employee") Employee employee);
    Optional<Favourites> findByEmployeeAndExercise(Employee employee, Exercise exercise);
    boolean existsByEmployeeAndExercise(Employee employee,Exercise exercise);
}
