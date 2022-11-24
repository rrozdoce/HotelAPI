package com.rrozdoce.hotelapi.repositories;

import com.rrozdoce.hotelapi.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
