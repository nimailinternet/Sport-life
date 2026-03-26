package org.example.Agonists;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Exercise.Exercise;
import org.example.Muscle.Muscle;

@Entity
@Data
@Table(name = "Agonists")
@AllArgsConstructor
@NoArgsConstructor
public class Agonists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "Muscle_id")
    private Muscle muscle;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Exercise_id")
    private Exercise exercise;
}
