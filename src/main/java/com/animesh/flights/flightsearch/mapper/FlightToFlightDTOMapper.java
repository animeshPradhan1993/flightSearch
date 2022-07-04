package com.animesh.flights.flightsearch.mapper;

import com.animesh.flights.flightsearch.model.domain.FlightDTO;
import com.animesh.flights.flightsearch.model.resource.Flight;

public class FlightToFlightDTOMapper {

	public FlightDTO map(Flight flight) {
		FlightDTO dto = new FlightDTO();
		dto.setArrivalTime(flight.getArrivalTime());
		dto.setDepartureTime(flight.getDepartureTime());
		dto.setDestination(flight.getDestination());
		dto.setFlightNumber(flight.getFlightNumber());
		dto.setOrigin(flight.getOrigin());
		dto.setPrice(flight.getPrice());
		dto.setTravelTime(dto.getArrivalTime().getTime() - dto.getDepartureTime().getTime());
		return dto;
	}
}
