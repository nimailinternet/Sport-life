package org.example.Males;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Exercise.Exercise;
import org.example.Male.Male;

@Entity
@Data
@Table(name = "Males")
@AllArgsConstructor
@NoArgsConstructor
public class Males {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "Male_id")
    private Male male;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Exercise_id")
    private Exercise exercise;
}
