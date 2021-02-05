package com.gokul.flightservice.controller;


import com.gokul.flightservice.dto.FlightDto;
import com.gokul.flightservice.entity.Flight;
import com.gokul.flightservice.repository.IFlightRepository;
import com.gokul.flightservice.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
public class FlightController {



    @Autowired
    IFlightService iFlightService;

    @GetMapping(path = "/flight/{id}")
    public FlightDto getFlight(@PathVariable(name = "id") @Positive Integer flightId){

        return iFlightService.getFlight(flightId);
    }

    @GetMapping(path = "/flight")
    public List<FlightDto>getAllFlights(){
        return iFlightService.getAllFlights();
    }

    @GetMapping(path = "/flight/flightData/{number}")
    public FlightDto getFlightByNumber(@PathVariable(name="number") String flightNumber){
        return iFlightService.getFlightByNumber(flightNumber);
    }

    @PostMapping(path = "/flight")
    public FlightDto createFlight(@RequestBody @Valid FlightDto flightDto){
        return iFlightService.postData(flightDto);

    }

    @PutMapping(path = "/flight")
    public FlightDto updateFlight(@RequestBody FlightDto flightDto){

        return iFlightService.updateFlight(flightDto);
    }

    @DeleteMapping(path = "/flight/delete/{id}")
    public void deleteFlight(@PathVariable(name = "id") Integer flightId){

        iFlightService.deleteFlight(flightId);
    }
}
