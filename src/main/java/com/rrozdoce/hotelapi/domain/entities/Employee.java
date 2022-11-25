package com.rrozdoce.hotelapi.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;
    @Column(name = "name")
    private String name;
    @Column(name = "adress")
    private String adress;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private Set<Client> clients;
}
