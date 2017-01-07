package org.craftedsw.tripservicekata.trip;

import java.util.Collections;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		User loggedUser = UserSession.getInstance().getLoggedUser();
		if (loggedUser != null) {			
			return user.getFriends().contains(loggedUser) ? TripDAO.findTripsByUser(user) 
														  : Collections.<Trip>emptyList();
		} else {
			throw new UserNotLoggedInException();
		}
	}	
}
