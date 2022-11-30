package com.rrozdoce.hotelapi.domain.repositories;

import com.rrozdoce.hotelapi.domain.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
