package org.example.Muscle;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Agonists.Agonists;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Muscle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Muscle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String photo;

    @OneToMany(mappedBy = "muscle", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Agonists> agonists=new ArrayList<>();

}
