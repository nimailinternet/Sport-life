package org.example.Favourites;

import jakarta.persistence.*;
import lombok.Data;
import org.example.Employee.Employee;
import org.example.Exercise.Exercise;

@Entity
@Data
@Table(name = "Favourites")
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
}
