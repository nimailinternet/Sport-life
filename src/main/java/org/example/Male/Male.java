package org.example.Male;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Males.Males;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Male")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Male {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String photo;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Males> males=new ArrayList<>();

}
