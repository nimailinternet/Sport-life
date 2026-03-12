package org.example.Employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Avatar_id")
    private Avatar avatar;
    private Long activity;
    private String experts;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Favourites> favourites=new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Calendar> calendars=new ArrayList<>();

    public Employee(String login, Avatar avatar, String password) {

    }
    public Employee(String login, String password) {

    }

    public String getPassword() {

        return password;
    }
    public String getExperts() {
        return experts;

    }
    public Long getActivity() {
        return activity;

    }
    public Avatar getAvatar() {
        return avatar;

    }
    public String getLogin() {
        return login;

    }

    public void setExperts(String experts) {
        this.experts = experts;


    }
    public void setLogin(String login) {
        this.login = login;

    }
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;

    }
    public void setActivity(Long activity) {
        this.activity = activity;

    }

}
