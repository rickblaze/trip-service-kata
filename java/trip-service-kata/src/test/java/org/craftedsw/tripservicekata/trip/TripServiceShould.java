package org.craftedsw.tripservicekata.trip;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import org.craftedsw.tripservicekata.data.UserData;
import org.craftedsw.tripservicekata.exception.TripServiceException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserSession.class,TripDAO.class})
public class TripServiceShould {
	
	private TripService tripService;	
	private UserData userData;
	
	@Before
	public void setUp(){
		tripService = new TripService();
		userData = new UserData();
		prepareMocks();
	}
	
	private void prepareMocks() {
		mockStatic(UserSession.class);
		mockStatic(TripDAO.class);
	}

	@Test
	public void return_trips_when_logged_user_is_a_friend() throws Exception{
		when(TripDAO.class, "findTrips", any(User.class)).thenReturn(userData.getTrips());
		assertEquals(1, tripService.getTrips(userData.createFriend(), userData.mockLoggedUser()).size());
	}
	
	@Test
	public void return_no_trips_when_logged_user_is_not_a_friend() throws Exception{	
		when(TripDAO.class, "findTrips", any(User.class)).thenReturn(userData.getTrips());
		assertEquals(0, tripService.getTrips(userData.createUnknown(), userData.mockLoggedUser()).size());
	}
	
	@Test(expected=TripServiceException.class)
	public void throw_trip_service_exception_when_logged_user_is_null() throws Exception{
		tripService.getTrips(null, null);
	}
}
