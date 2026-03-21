package org.example.Employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Calendar.Calendar;
import org.example.Favourites.Favourites;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private Long activity;
    private String experts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Avatar_id")
    private Avatar avatar;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Favourites> favourites=new ArrayList<>();
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Calendar> calendar=new ArrayList<>();

    public Employee(String login, Avatar avatar, String password,Long activity) {
        this.login=login;
        this.avatar=avatar;
        this.password=password;
        this.activity=activity;
    }
    public Employee(String login, String password,Long activity) {
        this.login=login;
        this.password=password;
        this.activity=activity;
    }
}
