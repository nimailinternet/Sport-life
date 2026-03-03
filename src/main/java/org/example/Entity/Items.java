package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="Inventory_id")
    private Inventory inventory;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Exercise_id")
    private Exercise exercise;
}
