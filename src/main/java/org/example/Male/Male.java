package org.example.Male;

import jakarta.persistence.*;
import lombok.Data;
import org.example.Males.Males;

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
    private String photo;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Males> males=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }
}
