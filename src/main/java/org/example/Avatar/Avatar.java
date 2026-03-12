package org.example.Avatar;

import jakarta.persistence.*;
import lombok.Data;
import org.example.Employee.Employee;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Avatar")
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Employee> employee=new ArrayList<>();
}
