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
@Data
@Table(name = "Employee")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private Long activity;
    private String experts;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Avatar_id")
    private Avatar avatar;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Favourites> favourites=new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Calendar> calendars=new ArrayList<>();

    public Employee(String login, Avatar avatar, String password) {
        this.login=login;
        this.avatar=avatar;
        this.password=password;
    }
    public Employee(String login, String password) {
        this.login=login;
        this.password=password;
    }
}
