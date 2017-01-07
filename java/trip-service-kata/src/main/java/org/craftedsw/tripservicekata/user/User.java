package org.craftedsw.tripservicekata.user;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.trip.Trip;

public class User {

	private List<Trip> trips;
	private List<User> friends;
	
	public User(){
		trips = new ArrayList<>();
		friends = new ArrayList<>();
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
}
