package org.craftedsw.tripservicekata.data;

import java.util.List;
import static java.util.Arrays.asList;

import org.craftedsw.tripservicekata.trip.Trip;

public class TripData {

	public Trip createTrip() {
		return new Trip();
	}
	
	public List<Trip> createTrips(){
		return asList(createTrip());
	}
}
