package com.rrozdoce.hotelapi.service;

import com.rrozdoce.hotelapi.domain.entities.Room;
import com.rrozdoce.hotelapi.rest.dtos.RoomDTO;

import java.util.List;
import java.util.Optional;

public interface RoomServiceImpl {

   Room save(RoomDTO dto);
   List<Room> findAll();
   void delete(Long id);
   void att(RoomDTO dto, Long id);

}
