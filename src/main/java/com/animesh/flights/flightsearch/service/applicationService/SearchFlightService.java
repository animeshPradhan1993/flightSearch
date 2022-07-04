package com.animesh.flights.flightsearch.service.applicationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.animesh.flights.flightsearch.Constant;
import com.animesh.flights.flightsearch.Params;
import com.animesh.flights.flightsearch.exception.BadRequestException;
import com.animesh.flights.flightsearch.model.domain.FlightDTO;
import com.animesh.flights.flightsearch.repository.FlightRepository;

public class SearchFlightService {

	@Autowired
	private FlightRepository repository;

	private Set<String> allowedFilters;

	public void init() {
		allowedFilters.add("origin");
		allowedFilters.add("destination");

	}

	public List<FlightDTO> searchFlights(Params params) throws BadRequestException {

		if (params.getOrigin() == null) {

			throw new BadRequestException("Please enter the origin");
		}
		if (params.getDestination() == null) {

			throw new BadRequestException("Please enter the destination");
		}

		List<FlightDTO> flightsSearched = new ArrayList<>();
		if (params.getSort() != null) {
			List<Order> sorts = null;
			sorts = new ArrayList<>();
			String[] sort = params.getSort().split("&");
			for (String s : sort) {
				String[] sortElements = s.split(Constant.COMA);
				if (sortElements.length > 1) {
					if (sortElements[1].equals(Constant.ASCENDING)) {

						sorts.add(new Order(Sort.Direction.ASC, sortElements[0]));
					} else if (sortElements[1].equals(Constant.PLUS)) {

						sorts.add(new Order(Sort.Direction.ASC, sortElements[0]));
					} else if (sortElements[1].equals(Constant.DESCENDING)) {

						sorts.add(new Order(Sort.Direction.DESC, sortElements[0]));
					} else if (sortElements[1].equals(Constant.MINUS)) {

						sorts.add(new Order(Sort.Direction.DESC, sortElements[0]));
					} 
				}
				else {
					sorts.add(new Order(Sort.Direction.ASC, sortElements[0]));
				}

			}
			Pageable pageable1 = PageRequest.of(0, 1000, Sort.by(sorts));
			flightsSearched = repository.searchFLightsBetweenOriginAndDestinationAndSort(params.getOrigin(),
					params.getDestination(), pageable1).getContent();
		} else {
			flightsSearched = repository.searchFLightsBetweenOriginAndDestination(params.getOrigin(),
					params.getDestination());
		}

		return flightsSearched;
	}

}
