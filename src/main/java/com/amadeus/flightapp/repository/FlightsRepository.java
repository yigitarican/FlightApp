package com.amadeus.flightapp.repository;

import com.amadeus.flightapp.entity.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface FlightsRepository extends JpaRepository<Flights, Integer> {
    @Query(value = "select f from Flights f where f.airportDeparture=?1 and f.airportArrival=?2 and f.dateDeparture=?3 and f.dateArrival=?4")
    List<Flights> findBySearch(int airportDeparture, int airportArrival, Date dateDeparture, Date dateArrival);
}
