package org.example.Employee;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("select a from Employee a join fetch a.avatar where a.login=:login")
    Optional<Employee> findByLoginWithAvatar(@Param("login") String login);
    @Query("select a from Employee a join fetch a.avatar order by a.activity desc")
    List<Employee> findAllByOrderByActivityDesc();
    Optional<Employee> findByLogin(String login);
}
