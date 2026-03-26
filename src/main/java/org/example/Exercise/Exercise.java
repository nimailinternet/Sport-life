package org.example.Exercise;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Favourites.Favourites;
import org.example.Items.Items;
import org.example.Agonists.Agonists;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Exercise")
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String video;
    private String description;
    private String photo;
    private String experts;

    @OneToMany(mappedBy = "exercise", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Favourites> favourites=new ArrayList<>();
    @OneToMany(mappedBy = "exercise", fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Agonists> agonists=new ArrayList<>();
    @OneToMany(mappedBy = "exercise", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Items> items=new ArrayList<>();
}
