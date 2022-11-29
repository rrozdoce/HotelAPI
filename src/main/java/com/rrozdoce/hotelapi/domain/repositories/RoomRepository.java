package com.rrozdoce.hotelapi.domain.repositories;

import com.rrozdoce.hotelapi.domain.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
