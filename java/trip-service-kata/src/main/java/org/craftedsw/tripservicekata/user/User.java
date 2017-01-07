package org.craftedsw.tripservicekata.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.craftedsw.tripservicekata.trip.Trip;

public class User {

	private List<Trip> trips = new ArrayList<>();
	private List<User> friends = new ArrayList<>();
	
	// Keeping it for TripService_Original.
	public List<User> getFriends() {
		return Collections.unmodifiableList(friends);
	}
	
	public void addFriend(User user) {
		friends.add(user);
	}

	public void addTrip(Trip trip) {
		trips.add(trip);
	}
	
	public boolean isFriend(User user){
		return friends.contains(user);
	}
	
	public boolean equals(Object object){
		if(object instanceof User){
			User userObjToCompare = (User)object;
			return trips.equals(userObjToCompare.trips)
					&& friends.equals(userObjToCompare.friends);
		}
		return Boolean.FALSE;
	}
	
	public int hashCode(){
		return trips.hashCode() * friends.hashCode() * (22/7);
	}
}
