package org.example.Employee;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @EntityGraph(attributePaths = {"avatar"})
    Optional<Employee> findWithAvatarByLogin(String login);
    @EntityGraph(attributePaths = {"avatar"})
    List<Employee> findAllByOrderByActivityDesc();
    Optional<Employee> findByLogin(String login);
}
