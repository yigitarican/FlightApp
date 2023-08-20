package com.amadeus.flightapp.service;

import com.amadeus.flightapp.entity.Airport;
import com.amadeus.flightapp.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    //POST methods
    public Airport saveAirport(Airport airport){
        return airportRepository.save(airport);
    }

    public List<Airport> saveAirports(List<Airport> airports){
        return airportRepository.saveAll(airports);
    }

    //GET methods
    public Airport getAirportById(int id){
        return airportRepository.findById(id).orElse(null);
    }

    public Airport getAirportByCity(String city){
        return airportRepository.findByCity(city);
    }

    public List<Airport> getAirports(){
        return airportRepository.findAll();
    }

    public String deleteAirport(int id){
        airportRepository.deleteById(id);
        return "product removed" + id;
    }

    public Airport updateAirport(Airport airport){
        Airport existingAirport = airportRepository.findById(airport.getId()).orElse(null);
        existingAirport.setCity(airport.getCity());
        return airportRepository.save(existingAirport);
    }
}
