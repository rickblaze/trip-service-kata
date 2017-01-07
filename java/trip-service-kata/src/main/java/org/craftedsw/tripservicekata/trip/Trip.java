package org.craftedsw.tripservicekata.trip;

import java.util.HashSet;
import java.util.Set;

public class Trip {
	
	private Set<String> visitedPlaces = new HashSet<>();
	private TripDate travelDates;
	
	public Trip(){
		
	}
	
	public Trip(Set<String> visitedPlaces){
		this.visitedPlaces = visitedPlaces;
	}
	
	public boolean addPlace(String newPlace){
		return visitedPlaces.add(newPlace);
	}

	public TripDate getTravelDates() {
		return travelDates;
	}

	public void setTravelDates(TripDate travelDates) {
		this.travelDates = travelDates;
	}
}
