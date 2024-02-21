package com.rentmazing.apartment.controller;

import com.rentmazing.apartment.entity.Client;
import com.rentmazing.apartment.entity.ClientApartment;
import com.rentmazing.apartment.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApartmentRestController {

    @Autowired
    private final ApartmentService apartmentService;

    public ApartmentRestController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping(value = "/hello")
    String hello() {
        return "It works!";
    }

    @GetMapping(value = "/api/clients")
    List<Client> getAllClients() {
        return apartmentService.getAllClients();
    }

    @GetMapping(value = "/api/apartments")
    List<ClientApartment> getAllApartments() {
        return apartmentService.getAllClientsApartments();
    }

}