package com.gokul.flightservice.service;

import com.gokul.flightservice.dto.FlightDto;

import java.util.List;

public interface IFlightService {

    public FlightDto updateFlight(FlightDto flightDto);

    public FlightDto postData(FlightDto flightDto);

    public FlightDto getFlight(Integer flightId);

    void deleteFlight(Integer flightId);

    public List<FlightDto> getAllFlights();

    public FlightDto getFlightByNumber(String flightNumber);
}
