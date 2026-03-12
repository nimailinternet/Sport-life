package org.example.Favourites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Employee.Employee;
import org.example.Exercise.Exercise;

@Entity
@Data
@Table(name = "Favourites")
@AllArgsConstructor
@NoArgsConstructor
public class Favourites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "Exercise_id")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Exercise exercise;
    @JoinColumn(name = "Employee_id")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Employee employee;

    public Favourites(Exercise exercise, Employee employee) {
    }

    public Employee getEmployee() {
        return employee;

    }
    public Exercise getExercise() {
        return exercise;

    }
}
