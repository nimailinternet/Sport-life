package org.example.Inventory;

import jakarta.persistence.*;
import lombok.Data;
import org.example.Items.Items;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String photo;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Items> items=new ArrayList<>();

    public String getName() {
        return name;

    }
}
