package com.rrozdoce.hotelapi.service.impl;

import com.rrozdoce.hotelapi.domain.entities.Client;
import com.rrozdoce.hotelapi.domain.entities.Room;
import com.rrozdoce.hotelapi.repositories.ClientRepository;
import com.rrozdoce.hotelapi.repositories.RoomRepository;
import com.rrozdoce.hotelapi.rest.dtos.RoomDTO;
import com.rrozdoce.hotelapi.service.RoomServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService  implements RoomServiceImpl {

    private final RoomRepository roomRepository;
    private final ClientRepository clientRepository;

    public RoomService(RoomRepository roomRepository, ClientRepository clientRepository) {
        this.roomRepository = roomRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

   public Room save(RoomDTO dto) {
        Long idClient = dto.getClient();
        Client client = clientRepository
               .findById(idClient)
               .orElseThrow(() -> new RuntimeException(" Client not found!"));
       return roomRepository.save(converter(dto, client));
   }

   public void delete(Long id) {
        roomRepository.deleteById(id);
   }

   public Room converter(RoomDTO dto, Client client) {
        Room room = new Room();
        room.setClient(client);
        room.setFloor(dto.getFloor());
        room.setNumber(dto.getNumber());
        return room;
   }
}
