package org.craftedsw.tripservicekata.trip;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import org.craftedsw.tripservicekata.data.UserData;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserSession.class,TripDAO.class})
public class TripServiceShould {
	
	private TripService tripService;	
	private UserSession mockUserSession;
	private UserData userData;
	
	@Before
	public void setUp(){
		tripService = new TripService();
		userData = new UserData();
		prepareMocks();
	}
	
	private void prepareMocks() {
		mockUserSession = PowerMockito.mock(UserSession.class);
		mockStatic(UserSession.class);
		mockStatic(TripDAO.class);
	}

	@Test
	public void return_trips_when_logged_user_is_a_friend() throws Exception{
		when(UserSession.class, "getInstance").thenReturn(mockUserSession);
		when(mockUserSession.getLoggedUser()).thenReturn(userData.mockLoggedUser());		
		when(TripDAO.class, "findTripsByUser", any(User.class)).thenReturn(userData.getTrips());
		assertEquals(1, tripService.getTripsByUser(userData.createFriend()).size());
	}
	
	@Test
	public void return_no_trips_when_logged_user_is_not_a_friend() throws Exception{	
		when(UserSession.class, "getInstance").thenReturn(mockUserSession);
		when(mockUserSession.getLoggedUser()).thenReturn(userData.mockLoggedUser());		
		when(TripDAO.class, "findTripsByUser", any(User.class)).thenReturn(userData.getTrips());
		assertEquals(0, tripService.getTripsByUser(userData.createUnknown()).size());
	}
	
	@Test(expected=UserNotLoggedInException.class)
	public void throw_user_not_logged_exception_when_logged_user_is_null() throws Exception{
		when(UserSession.class, "getInstance").thenReturn(mockUserSession);
		when(mockUserSession.getLoggedUser()).thenReturn(null);
		tripService.getTripsByUser(null);
	}
}
