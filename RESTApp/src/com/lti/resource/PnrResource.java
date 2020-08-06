package com.lti.resource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.lti.resource.Passenger.Gender;
import com.lti.resource.Passenger.Status;

@Path("/pnr")
public class PnrResource {

	@GET
	//@Produces("application/json")
	//If we uses POST method then we use @Consumes
	@Produces(MediaType.APPLICATION_JSON)
	public Pnr check(@QueryParam("pnrNo") int pnrNo, @Context HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		//for time being we will return some hardcoded data
		//in a real app, from here we will hit the DB and fetch the data dynamically
		
		Pnr pnr = new Pnr();
		pnr.setPnrNo(pnrNo);
		pnr.setTrainNo(12345);
		pnr.setTravelDate(LocalDate.of(2020, 12, 25));
		
		List<Passenger> passengers = new ArrayList<>();
		passengers.add(new Passenger("Archit", Gender.MALE, Status.CONFIRMED));
		passengers.add(new Passenger("Ankur", Gender.MALE, Status.RAC));
		passengers.add(new Passenger("Garima", Gender.FEMALE, Status.WAITING));
		passengers.add(new Passenger("Sarthak", Gender.MALE, Status.WAITING));
		passengers.add(new Passenger("Tanmay", Gender.MALE, Status.RAC));
		pnr.setPassengers(passengers);
		
		return pnr;
	}
}
