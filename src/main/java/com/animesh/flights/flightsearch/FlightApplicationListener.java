package com.animesh.flights.flightsearch;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.animesh.flights.flightsearch.exception.BadRequestException;
import com.animesh.flights.flightsearch.model.domain.FlightDTO;
import com.animesh.flights.flightsearch.service.applicationService.CreateFlightService;

@Component
@Order(0)
public class FlightApplicationListener implements ApplicationListener<ApplicationReadyEvent> {
	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {

		try {
			this.createFlights();
		} catch (BadRequestException e) {

			e.printStackTrace();
		}

	}

	public void createFlights() throws BadRequestException {
		CreateFlightService createFlightService = (CreateFlightService) applicationContext
				.getBean(CreateFlightService.class);

		createFlightService.createFLight(createFlightData("A101", "AMS", "DEL", "11:00", "17:00", new BigDecimal(850)));
		createFlightService.createFLight(createFlightData("B101", "AMS", "BOM", "12:00", "19:30", new BigDecimal(750)));

		createFlightService.createFLight(createFlightData("C101", "AMS", "BLR", "13:00", "18:30", new BigDecimal(800)));
		createFlightService.createFLight(createFlightData("D101", "AMS", "MAA", "09:00", "15:00", new BigDecimal(600)));

		createFlightService.createFLight(createFlightData("E101", "MAA", "BOM", "16:00", "17:30", new BigDecimal(100)));

		createFlightService.createFLight(createFlightData("F101", "BOM", "DEL", "20:30", "21:30", new BigDecimal(80)));

		createFlightService.createFLight(createFlightData("G101", "BOM", "DEL", "18:00", "19:30", new BigDecimal(100)));

		createFlightService.createFLight(createFlightData("A201", "LHR", "DEL", "11:30", "17:00", new BigDecimal(600)));

		createFlightService.createFLight(createFlightData("B201", "LHR", "BOM", "12:35", "19:30", new BigDecimal(750)));

		createFlightService.createFLight(createFlightData("C201", "LHR", "BLR", "13:45", "18:30", new BigDecimal(800)));

		createFlightService.createFLight(createFlightData("D201", "LHR", "MAA", "09:00", "15:00", new BigDecimal(600)));

		createFlightService.createFLight(createFlightData("E201", "DEL", "BOM", "18:45", "20:15", new BigDecimal(100)));

		createFlightService.createFLight(createFlightData("F201", "BOM", "DEL", "21:15", "22:30", new BigDecimal(80)));

		createFlightService.createFLight(createFlightData("G01", "BOM", "DEL", "20:20", "22:30", new BigDecimal(100)));

	}

	public FlightDTO createFlightData(String flightNumber, String origin, String destination, String departureTime,
			String arrivalTime, BigDecimal price) {
		FlightDTO f1 = new FlightDTO();
		f1.setArrivalTime(createDateObject(arrivalTime));
		f1.setDepartureTime(createDateObject(departureTime));
		f1.setDestination(destination);
		f1.setFlightNumber(flightNumber);
		f1.setOrigin(origin);
		f1.setPrice(price);
		f1.setTravelTime(f1.getArrivalTime().getTime() - f1.getDepartureTime().getTime());
		return f1;
	}

	public Date createDateObject(String date) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		try {
			return format.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException("Error parsing Date");
		}
	}
}
