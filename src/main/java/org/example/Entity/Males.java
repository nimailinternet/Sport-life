package org.example.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

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
}
