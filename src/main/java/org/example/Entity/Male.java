package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Male")
@Data
public class Male {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Males> males=new ArrayList<>();
}
