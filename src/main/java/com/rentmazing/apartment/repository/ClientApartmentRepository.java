package com.rentmazing.apartment.repository;

import com.rentmazing.apartment.entity.ClientApartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientApartmentRepository extends JpaRepository<ClientApartment, UUID> {

}
