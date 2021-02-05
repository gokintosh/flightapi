package com.gokul.flightservice.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.gokul.flightservice.dto.FlightDto;
import com.gokul.flightservice.entity.Flight;
import com.gokul.flightservice.repository.IFlightRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FlightService implements IFlightService {

    @Autowired
    IFlightRepository iFlightRepository;


    @Override
    public FlightDto updateFlight(FlightDto flightDto) {
        Flight flight=iFlightRepository.findById(flightDto.getId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No resource found"));
            BeanUtils.copyProperties(flightDto,flight);
            flight=iFlightRepository.save(flight);
            BeanUtils.copyProperties(flight,flightDto);
            return flightDto;
    }

    @Override
    public FlightDto postData(FlightDto flightDto) {
        Flight flight=new Flight();
        BeanUtils.copyProperties(flightDto,flight);
        flight=iFlightRepository.save(flight);
        BeanUtils.copyProperties(flight,flightDto);
        return flightDto;
    }

    @Override
    public FlightDto getFlight(Integer flightId) {
        Flight flight=iFlightRepository.findById(flightId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"resource not found"));
        FlightDto dto= new FlightDto();
            BeanUtils.copyProperties(flight,dto);
        return dto;
    }

    @Override
    public void deleteFlight(Integer flightId) {
        iFlightRepository.findById(flightId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"resource not found"));
        iFlightRepository.deleteById(flightId);


    }

    @Override
    public List<FlightDto> getAllFlights() {
        Iterable<Flight> iterable=iFlightRepository.findAll();
//        java stream
        List<FlightDto>flights=StreamSupport.stream(iterable.spliterator(),false).map(flight ->{
            FlightDto dto=new FlightDto();
            BeanUtils.copyProperties(flight,dto);
            return dto;
        }).collect(Collectors.toList());
        return flights;
    }


    @Override
    public FlightDto getFlightByNumber(String flightNumber) {
        Flight flight=iFlightRepository.findByFlightNumber(flightNumber);

        FlightDto dto=new FlightDto();
        BeanUtils.copyProperties(flight,dto);
        return dto;

    }
}
