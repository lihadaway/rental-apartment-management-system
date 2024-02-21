package com.rentmazing.apartment.service;

import com.rentmazing.apartment.entity.Client;
import com.rentmazing.apartment.entity.ClientApartment;
import com.rentmazing.apartment.repository.ClientApartmentRepository;
import com.rentmazing.apartment.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientApartmentRepository clientApartmentRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public List<ClientApartment> getAllClientsApartments() {
        return clientApartmentRepository.findAll();
    }
}
