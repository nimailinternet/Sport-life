package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

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
