package com.amadeus.flightapp.service;

import com.amadeus.flightapp.entity.Flights;
import com.amadeus.flightapp.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FlightsService {

    @Autowired
    private FlightsRepository flightsRepository;

    //POST Methods
    public Flights saveFlight(Flights flight ){
        return flightsRepository.save(flight);
    }

    public List<Flights> saveFlight(List<Flights> flights){
        return flightsRepository.saveAll(flights);
    }

    public List<Flights> getFlights(){
        return flightsRepository.findAll();
    }

    public Flights getFlightById(int id){
        return flightsRepository.findById(id).orElse(null);
    }

    public String deleteFlight(int id){
        flightsRepository.deleteById(id);
        return "flight with id:" + id + " deleted";
    }

    public List<Flights> searchFlights(Flights flight){
        List<Flights> flights = flightsRepository.findBySearch(flight.getAirportDeparture(),flight.getAirportArrival(),flight.getDateDeparture(),flight.getDateArrival());
        return flights;
    }

    public Flights updateFlight(Flights flight){
        Flights existingFlight = flightsRepository.findById(flight.getId()).orElse(null);
        existingFlight.setAirportDeparture(flight.getAirportDeparture());
        existingFlight.setAirportArrival(flight.getAirportArrival());
        existingFlight.setDateDeparture(flight.getDateDeparture());
        existingFlight.setDateArrival(flight.getDateArrival());
        existingFlight.setPrice(flight.getPrice());
        return flightsRepository.save(flight);
    }
}
