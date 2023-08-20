package com.amadeus.flightapp.repository;

import com.amadeus.flightapp.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Integer> {

    Airport findByCity(String city);
}
