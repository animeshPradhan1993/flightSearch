package com.animesh.flights.flightsearch.service.applicationService;

import org.springframework.beans.factory.annotation.Autowired;

import com.animesh.flights.flightsearch.exception.BadRequestException;
import com.animesh.flights.flightsearch.model.domain.FlightDTO;
import com.animesh.flights.flightsearch.repository.FlightRepository;
import com.animesh.flights.flightsearch.service.validation.CreateFlightValidator;

public class CreateFlightService {

	@Autowired
	private FlightRepository repository;
	@Autowired
	private CreateFlightValidator createValidator;

	public FlightDTO createFLight(FlightDTO flightdto) throws BadRequestException {
		createValidator.validateMandatoryFields(flightdto);
		return repository.save(flightdto);
	}
}
