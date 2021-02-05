package com.gokul.flightservice.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "flight")
public class Flight {

    @Id
    @Column(name = "flight_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "flight_number",nullable = false)
    private String flightNumber;

    @Column(name = "capacity",nullable = false)
    private Integer capacity;

    @Column(name = "manufactured_by",nullable = false)
    private String mfdby;

    @Column(name = "manufactured_on",nullable = false)
    private LocalDate mfdon;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getMfdby() {
        return mfdby;
    }

    public void setMfdby(String mfdby) {
        this.mfdby = mfdby;
    }

    public LocalDate getMfdon() {
        return mfdon;
    }

    public void setMfdon(LocalDate mfdon) {
        this.mfdon = mfdon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
