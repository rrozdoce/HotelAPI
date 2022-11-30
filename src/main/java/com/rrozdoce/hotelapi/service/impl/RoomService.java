package com.rrozdoce.hotelapi.service.impl;

import com.rrozdoce.hotelapi.domain.entities.Client;
import com.rrozdoce.hotelapi.domain.entities.Room;
import com.rrozdoce.hotelapi.domain.repositories.ClientRepository;
import com.rrozdoce.hotelapi.domain.repositories.RoomRepository;
import com.rrozdoce.hotelapi.exceptions.ModelNotFoundExeption;
import com.rrozdoce.hotelapi.rest.dtos.RoomDTO;
import com.rrozdoce.hotelapi.service.RoomServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

   @Transactional
   @Override
   public Room save(RoomDTO dto) {
        Long idClient = dto.getClient();
        Client client = clientRepository
               .findById(idClient)
               .orElseThrow(() -> new ModelNotFoundExeption("Client not found, id: " + idClient));
       return roomRepository.save(convert(dto, client));
   }

   @Transactional
   @Override
   public void delete(Long id) {
        roomRepository.deleteById(id);
   }

   @Transactional
   @Override
   public Room att(RoomDTO dto , Long id) {
       Long idClient = dto.getClient();
       Client client = clientRepository
               .findById(idClient)
               .orElseThrow(() -> new ModelNotFoundExeption(" Client not found, id" + idClient) );
       Room room = convert(dto, client);

      return roomRepository
               .findById(id)
               .map(OldRoom -> {
                   room.setRoom_id(OldRoom.getRoom_id());
                   roomRepository.save(room);
                   return OldRoom;
               }).orElseThrow( () -> new ModelNotFoundExeption("Room not found, id: " + id));
   }

   public Room convert(RoomDTO dto, Client client) {
        Room room = new Room();
        room.setClient(client);
        room.setFloor(dto.getFloor());
        room.setNumber(dto.getNumber());
        return room;
   }
}
