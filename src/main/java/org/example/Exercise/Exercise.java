package org.example.Exercise;

import jakarta.persistence.*;
import lombok.Data;
import org.example.Favourites.Favourites;
import org.example.Items.Items;
import org.example.Males.Males;

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
    private String photo;
    private String experts;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Favourites> favourites=new ArrayList<>();
    @OneToMany(fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Males> males=new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Items> items=new ArrayList<>();

    public String getName() {
        return name;

    }
    public String getVideo() {
        return video;

    }
    public String getPhoto() {
        return photo;

    }
    public String getDescription() {
        return description;

    }
    public String getExperts() {
        return experts;

    }
}
