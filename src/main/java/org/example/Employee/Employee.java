package org.example.Employee;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.example.Avatar.Avatar;
import org.example.Calendar.Calendar;
import org.example.Favourites.Favourites;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Employee")
@Builder
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
    private Long activity;
    private String expertise;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Calendar> calendars=new ArrayList<>();

    public Employee(String login, Avatar avatar, String password) {
    }

    public String getPassword() {
        return password;
    }
}
