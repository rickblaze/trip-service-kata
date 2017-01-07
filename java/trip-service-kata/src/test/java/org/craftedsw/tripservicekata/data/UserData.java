package org.craftedsw.tripservicekata.data;

import java.util.Collections;
import java.util.List;

import org.craftedsw.tripservicekata.trip.Trip;
import org.craftedsw.tripservicekata.user.User;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserData {
	
	private TripData tripData;
	private User mockUser;
	
	public UserData(){
		tripData = new TripData();
		mockUser = Mockito.mock(User.class);
	}
	
	public User createFriend(){
		User user = new User();
		user.addFriend(mockUser);
		user.addTrip(tripData.createTrip());
		return user;
	}
	
	public User createUnknown(){
		User user = new User();
		user.addFriend(new User());
		user.addTrip(tripData.createTrip());
		return user;
	}
	
	public User mockLoggedUser(){
		return mockUser;
	}
	
	public List<Trip> getTrips(){
		return Collections.unmodifiableList(tripData.createTrips());
	}
}
