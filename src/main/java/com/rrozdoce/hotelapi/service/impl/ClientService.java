package com.rrozdoce.hotelapi.service.impl;

import com.rrozdoce.hotelapi.domain.entities.Client;
import com.rrozdoce.hotelapi.domain.entities.Employee;
import com.rrozdoce.hotelapi.domain.repositories.ClientRepository;
import com.rrozdoce.hotelapi.domain.repositories.EmployeeRepository;
import com.rrozdoce.hotelapi.domain.repositories.RoomRepository;
import com.rrozdoce.hotelapi.exceptions.ModelNotFoundExeption;
import com.rrozdoce.hotelapi.rest.dtos.ClientDTO;
import com.rrozdoce.hotelapi.service.ClientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClientService implements ClientServiceImpl {

    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;
    private final RoomRepository roomRepository;

    public ClientService(ClientRepository clientRepository, EmployeeRepository employeeRepository, RoomRepository roomRepository) {
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public Client save(ClientDTO dto) {
        Long idEmployee = dto.getEmployee();
        Employee employee = employeeRepository
                .findById(idEmployee)
                .orElseThrow(() -> new ModelNotFoundExeption("Employee not found!!"));
        return clientRepository.save(convert(dto, employee));
    }

    @Override
    public List<Client> findAll() {
        return  clientRepository.findAll();
    }

    @Override
    public void delete(Long id) {
         clientRepository.deleteById(id);
    }

    @Override
    public void update(ClientDTO dto, Long id) {
        Long idEmployee = dto.getEmployee();
        Employee employee = employeeRepository
                .findById(idEmployee)
                .orElseThrow(() -> new ModelNotFoundExeption("Employee not found!!"));
        Client client = convert(dto, employee);

        clientRepository.findById(id)
                .map(OldClient -> {
                    client.setEmployee(OldClient.getEmployee());
                    clientRepository.save(client);
                    return OldClient;
                }).orElseThrow( () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Client not found!!"));
    }

    public Client convert(ClientDTO dto, Employee employee) {
        Client client = new Client();
        client.setEmployee(employee);
        client.setName(dto.getName());
        client.setAdress(dto.getAdress());
        return client;
    }
}
