package org.example.Males;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.example.Exercise.Exercise;
import org.example.Male.Male;

@Entity
@Data
@Table(name = "Males")
@Builder
public class Males {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Male_id")
    private Male male;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Exercise_id")
    private Exercise exercise;

    public Long getId() {
        return id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Male getMale() {
        return male;
    }
}
