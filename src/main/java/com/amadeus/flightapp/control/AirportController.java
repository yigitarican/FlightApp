package com.amadeus.flightapp.control;

import com.amadeus.flightapp.entity.Airport;
import com.amadeus.flightapp.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.List;

@RestController
public class AirportController {

    @Autowired
    private AirportService service;

    @PostMapping("/addAirport")
    public Airport addAirport(@RequestBody Airport airport){
        return service.saveAirport(airport);
    }

    @PostMapping("/addAirports")
    public List<Airport> addAirport(@RequestBody List<Airport> airports){
        return service.saveAirports(airports);
    }

    @GetMapping("/airports")
    public List<Airport> findAllAirports(){
        return service.getAirports();
    }

    @GetMapping("/airportById/{id}")
    public Airport findAirportById(@PathVariable int id){
        return service.getAirportById(id);
    }

    @GetMapping("/airport/{city}")
    public Airport findAirportByName(@PathVariable String city){
        return service.getAirportByCity(city);
    }

    @PutMapping("/updateAirport")
    public Airport updateAirport(@RequestBody Airport airport){
        return service.updateAirport(airport);
    }

    @DeleteMapping("/deleteAirport/{id}")
    public String deleteAirport(@PathVariable int id){
        return service.deleteAirport(id);
    }
}
