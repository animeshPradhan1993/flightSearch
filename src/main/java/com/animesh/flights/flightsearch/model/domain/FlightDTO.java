package com.animesh.flights.flightsearch.model.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity()
@Table(name = "flights")
public class FlightDTO {
	@Id
	@Column(unique = true, nullable = false)
	private String flightNumber;

	@Column(nullable = false)
	private String origin;

	@Column(nullable = false)
	private String destination;

	@Column(name = "departureTime", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date departureTime;

	@Column(name = "arrivalTime", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date arrivalTime;

	@Column(nullable = false)
	private BigDecimal price;

	@Column
	private Long travelTime;

	public Long getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(Long travelTime) {
		this.travelTime = travelTime;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
