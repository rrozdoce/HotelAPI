package com.rrozdoce.hotelapi.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long room_id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "floor")
    private Integer floor;
    @Column(name = "number")
    private Integer number;
}
