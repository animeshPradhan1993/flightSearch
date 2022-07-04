package com.animesh.flights.flightsearch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.animesh.flights.flightsearch.mapper.FlightDTOToFlightMapper;
import com.animesh.flights.flightsearch.mapper.FlightToFlightDTOMapper;
import com.animesh.flights.flightsearch.service.applicationService.CreateFlightService;
import com.animesh.flights.flightsearch.service.applicationService.SearchFlightService;
import com.animesh.flights.flightsearch.service.validation.CreateFlightValidator;

@Configuration
public class FlightsConfiguration {
	@Bean
	public SearchFlightService searchFlightService() {
		return new SearchFlightService();
	}

	@Bean
	public CreateFlightService createFlightService() {
		return new CreateFlightService();
	}


	@Bean
	public FlightDTOToFlightMapper flightDTOToFlightMapper() {
		return new FlightDTOToFlightMapper();
	}

	@Bean
	public FlightToFlightDTOMapper flightToFlightDTOMapper() {
		return new FlightToFlightDTOMapper();
	}
	@Bean
	public CreateFlightValidator createFlightValidator() {
		return new CreateFlightValidator();
	}
}
