package com.gokul.flightservice.repository;

import com.gokul.flightservice.entity.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IFlightRepository extends CrudRepository<Flight, Integer> {
    Flight findByFlightNumber(String flightNumber);

}
