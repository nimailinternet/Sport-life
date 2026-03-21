package org.example.Calendar;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Employee.Employee;

import java.time.LocalDateTime;

@Entity
@Table(name = "Calendar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Employee_id")
    private Employee employee;

    public Calendar(LocalDateTime date, Employee employee) {
        this.date=date;
        this.employee=employee;
    }
}
