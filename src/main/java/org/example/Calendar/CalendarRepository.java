package org.example.Calendar;

import org.example.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar,Long> {
    List<Calendar> findByEmployee(Employee employee);
    @Query("select c from Calendar c join fetch c.employee where c.employee=:employee and c.date=:date")
    Optional<Calendar> findByEmployeeAndDate(@Param("employee") Employee employee, @Param("date") LocalDateTime date);
}
