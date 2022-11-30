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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClientService implements ClientServiceImpl {

    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;

    public ClientService(ClientRepository clientRepository, EmployeeRepository employeeRepository) {
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @Override
    public Client save(ClientDTO dto) {
        Long idEmployee = dto.getEmployee();
        Employee employee = employeeRepository
                .findById(idEmployee)
                .orElseThrow(() -> new ModelNotFoundExeption("Employee not found, id: " + idEmployee));
        return clientRepository.save(convert(dto, employee));
    }

    @Override
    public List<Client> findAll() {
        return  clientRepository.findAll();
    }

    @Transactional
    @Override
    public void delete(Long id) {
         clientRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Client update(ClientDTO dto, Long id) {
        Long idEmployee = dto.getEmployee();
        Employee employee = employeeRepository
                .findById(idEmployee)
                .orElseThrow(() -> new ModelNotFoundExeption("Employee not found, id: " + idEmployee));
        Client client = convert(dto, employee);

       return clientRepository.findById(id)
                .map(OldClient -> {
                    client.setClient_id(id);
                    clientRepository.save(client);
                    return OldClient;
                }).orElseThrow( () -> new ModelNotFoundExeption("Client not found, id: " + id));
    }

    public Client convert(ClientDTO dto, Employee employee) {
        Client client = new Client();
        client.setEmployee(employee);
        client.setName(dto.getName());
        client.setAdress(dto.getAdress());
        return client;
    }
}
