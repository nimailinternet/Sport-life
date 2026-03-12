package org.example.Calendar;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Employee.Employee;

import java.time.LocalDateTime;

@Entity
@Table(name = "Calendar")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Employee_id")
    private Employee employee;

    public Calendar(LocalDateTime dateTime, Employee employee) {
    }

    public LocalDateTime getDate() {
        return date;

    }
}
