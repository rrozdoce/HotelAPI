package com.rrozdoce.hotelapi.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(name = "name")
    private String name;
    @Column(name = "adress")
    private String adress;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    @JsonIgnore // recursive infinite error without this
    private Set<Room> rooms;
}
