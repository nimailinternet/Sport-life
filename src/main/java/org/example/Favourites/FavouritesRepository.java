package org.example.Favourites;

import org.example.Employee.Employee;
import org.example.Exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FavouritesRepository extends JpaRepository<Favourites,Long> {
    List<Favourites> findByExercise(Exercise exercise);
    List<Favourites> findByEmployee(Employee employee);
}
