package com.animesh.flights.flightsearch.mapper;

import com.animesh.flights.flightsearch.model.domain.FlightDTO;
import com.animesh.flights.flightsearch.model.resource.Flight;

public class FlightDTOToFlightMapper {
	public Flight map(FlightDTO dto) {
		Flight flight = new Flight();
		flight.setArrivalTime(dto.getArrivalTime());
		flight.setDepartureTime(dto.getDepartureTime());
		flight.setDestination(dto.getDestination());
		flight.setFlightNumber(dto.getFlightNumber());
		flight.setOrigin(dto.getOrigin());
		flight.setPrice(dto.getPrice());
		return flight;
	}
}
