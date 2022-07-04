package com.animesh.flights.flightsearch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.animesh.flights.flightsearch.Params;
import com.animesh.flights.flightsearch.exception.BadRequestException;
import com.animesh.flights.flightsearch.mapper.FlightDTOToFlightMapper;
import com.animesh.flights.flightsearch.mapper.FlightToFlightDTOMapper;
import com.animesh.flights.flightsearch.model.domain.FlightDTO;
import com.animesh.flights.flightsearch.model.resource.Flight;
import com.animesh.flights.flightsearch.service.applicationService.CreateFlightService;
import com.animesh.flights.flightsearch.service.applicationService.SearchFlightService;

@RestController
@RequestMapping("/flight/v1")
public class FlightController {

	@Autowired
	private CreateFlightService createFlightService;

	@Autowired
	private SearchFlightService searchFlightService;

	@Autowired
	private FlightDTOToFlightMapper flightDTOToFlightMapper;

	@Autowired
	private FlightToFlightDTOMapper flightToFlightDTOMapper;

	@GetMapping("/flight")
	public List<Flight> getAllFlights(Params params) throws BadRequestException {

		List<FlightDTO> dtoList = searchFlightService.searchFlights(params);
		List<Flight> flights = new ArrayList<>();
		dtoList.forEach(flight -> flights.add(flightDTOToFlightMapper.map(flight)));
		return flights;
	}

	@PostMapping("/flight")
	public ResponseEntity<Flight> createCustomer(@RequestBody Flight flight) throws BadRequestException {
		Flight flightResponse = flightDTOToFlightMapper
				.map(createFlightService.createFLight(flightToFlightDTOMapper.map(flight)));

		return new ResponseEntity<Flight>(flightResponse, HttpStatus.CREATED);

	}

}
