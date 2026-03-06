package org.example.Items;

import jakarta.persistence.*;
import lombok.Data;
import org.example.Exercise.Exercise;
import org.example.Inventory.Inventory;

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
