package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Avatar_id")
    private Avatar avatar;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Favourites> favourites=new ArrayList<>();
}
