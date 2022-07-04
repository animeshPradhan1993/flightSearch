package com.animesh.flights.flightsearch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.animesh.flights.flightsearch.model.domain.FlightDTO;

@Repository
public interface FlightRepository extends JpaRepository<FlightDTO, Long> {
	// @Query(value = "SELECT * FROM FLIGHTS WHERE origin = ?1 AND destination=?2")
	// List<FlightDTO> searchFLightsBetweenOriginAndDestination(String origin,
	// String destination, Sort sort);

	@Query(value = "SELECT * FROM flights WHERE ORIGIN = ?1 AND DESTINATION=?2", nativeQuery = true)
	Page<FlightDTO> searchFLightsBetweenOriginAndDestinationAndSort(String origin, String destination, Pageable sort);

	@Query(value = "SELECT * FROM flights WHERE ORIGIN = ?1 AND DESTINATION=?2", nativeQuery = true)
	List<FlightDTO> searchFLightsBetweenOriginAndDestination(String origin, String destination);

}
