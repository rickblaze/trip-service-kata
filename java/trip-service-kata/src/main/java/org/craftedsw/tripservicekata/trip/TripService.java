package org.craftedsw.tripservicekata.trip;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.craftedsw.tripservicekata.exception.TripServiceException;
import org.craftedsw.tripservicekata.user.User;

public class TripService {

	public List<Trip> getTrips(User user, User loggedInUser) {
		if(Objects.isNull(loggedInUser)){
			throw new TripServiceException("Logged User Details are not provided.");
		}else{
			return user.isFriend(loggedInUser) ? TripDAO.findTrips(user) 
					 						   : Collections.<Trip>emptyList();
		}		
	}
}
