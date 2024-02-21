package com.rentmazing.apartment.service;

import com.rentmazing.apartment.entity.Client;
import com.rentmazing.apartment.entity.ClientApartment;
import com.rentmazing.apartment.repository.ClientApartmentRepository;
import com.rentmazing.apartment.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.rentmazing.apartment.repository.ClientApartmentSpecialization.*;

@Service
public class ApartmentService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientApartmentRepository clientApartmentRepository;

/*

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public List<ClientApartment> getAllClientsApartments() {
        return clientApartmentRepository.findAll();
    }
*/

    public List<Client> findClients(String optionalClientId) {
        if (optionalClientId != null) {
            var clientIDs = List.of(
                    UUID.fromString(optionalClientId)
            );

            return clientRepository.findAllById(clientIDs);
        } else {
            return clientRepository.findAll();
        }
    }

    public List<ClientApartment> findApartments(
            String city, Integer minPrice, Integer maxPrice, Boolean isAvailableForRent) {

        Specification<ClientApartment> specification = Specification.where(null);

        if (city != null) {
            specification = specification.and(cityContainsIgnoreCase(city));
        }

        if (minPrice != null && maxPrice != null) {
            specification = specification.and(rentPriceBetween(minPrice, maxPrice));
        }

        if (isAvailableForRent != null) {
            specification = specification.and(isAvailableForRent(isAvailableForRent));
        }

        return clientApartmentRepository.findAll(specification);
    }
}
