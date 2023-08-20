package com.amadeus.flightapp.control;

import com.amadeus.flightapp.entity.Flights;
import com.amadeus.flightapp.service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class FlightsController {

    @Autowired
    private FlightsService service;

    @PostMapping("/addFlight")
    public Flights addFlight(@RequestBody Flights flight){
        return service.saveFlight(flight);
    }

    @PostMapping("/addFlights")
    public List<Flights> addFlights(@RequestBody List<Flights> flights){
        return service.saveFlight(flights);
    }

    @GetMapping("/flights")
    public List<Flights> findAllFlights(){
        return service.getFlights();
    }

    @GetMapping("/flights/{id}")
    public Flights findFlightById(@PathVariable int id){
        return service.getFlightById(id);
    }

    @PutMapping("/updateFlight")
    public Flights updateFlight(@RequestBody Flights flight){
        return service.updateFlight(flight);
    }

    @DeleteMapping("/deleteFlight/{id}")
    public String deleteFlight(@PathVariable int id){
        return service.deleteFlight(id);
    }

    @PostMapping("/searchFlights/")
    public List<Flights> searchFlights(@RequestBody Flights flight){
        return service.searchFlights(flight);
    }
}
