package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String video;
    private String description;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Favourites> favourites=new ArrayList<>();
    @OneToMany(fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Males> males=new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Items> items=new ArrayList<>();
}
