package com.gokul.flightservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gokul.flightservice.validation.FlightMfdBy;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.util.Objects;

public class FlightDto {


    private Integer id;


    @NotNull
    private String flightNumber;


    @NotNull
    @PositiveOrZero
    private Integer capacity;


    @NotNull
    @FlightMfdBy
    private String mfdby;

    @NotNull
    @Past
    @JsonFormat(pattern = "MM/dd/yyyy")
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
        FlightDto flightDto = (FlightDto) o;
        return Objects.equals(id, flightDto.id) &&
                Objects.equals(flightNumber, flightDto.flightNumber) &&
                Objects.equals(capacity, flightDto.capacity) &&
                Objects.equals(mfdby, flightDto.mfdby) &&
                Objects.equals(mfdon, flightDto.mfdon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightNumber, capacity, mfdby, mfdon);
    }

    @Override
    public String toString() {
        return "FlightDto{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", capacity=" + capacity +
                ", mfdby='" + mfdby + '\'' +
                ", mfdon=" + mfdon +
                '}';
    }
}
