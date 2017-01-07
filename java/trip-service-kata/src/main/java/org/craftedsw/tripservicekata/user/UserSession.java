package org.craftedsw.tripservicekata.user;


public class UserSession {
	
	private User loggedUser;

	private UserSession(User loggedUser) {
		this.loggedUser = loggedUser;
	}
	
	public User getLoggedUser() {
		return loggedUser;
	}
}
