package com.amadeus.flightapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flights")
public class Flights {

    @Id
    @GeneratedValue
    private int Id;
    private int airportDeparture;
    private int airportArrival;
    private Date dateDeparture;
    private Date dateArrival;
    private double price;


}
