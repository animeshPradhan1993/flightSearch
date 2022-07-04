package com.animesh.flights.flightsearch.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import com.animesh.flights.flightsearch.Constant;
import com.animesh.flights.flightsearch.exception.BadRequestException;
import com.animesh.flights.flightsearch.model.domain.FlightDTO;

public class CreateFlightValidator {

	public void validateMandatoryFields(FlightDTO flight) throws BadRequestException {
		List<String> mandatoryFields = new ArrayList<>();
		if (StringUtils.isEmpty(flight.getArrivalTime())) {
			mandatoryFields.add(Constant.ARRIVAL_TIME);
		}
		if (StringUtils.isEmpty(flight.getDepartureTime())) {
			mandatoryFields.add(Constant.DEPARTURE_TIME);
		}
		if (StringUtils.isEmpty(flight.getDestination())) {
			mandatoryFields.add(Constant.DESTINATION);
		}

		if (StringUtils.isEmpty(flight.getFlightNumber())) {
			mandatoryFields.add(Constant.FLIGHT_NUMBER);
		}

		if (StringUtils.isEmpty(flight.getOrigin())) {
			mandatoryFields.add(Constant.ORIGIN);
		}
		if (StringUtils.isEmpty(flight.getDestination())) {
			mandatoryFields.add(Constant.DESTINATION);
		}
		if (!mandatoryFields.isEmpty()) {
			throw new BadRequestException(
					Constant.MANDATORY_FIELDS + mandatoryFields.stream().collect(Collectors.joining(", ")));
		}

	}
}
