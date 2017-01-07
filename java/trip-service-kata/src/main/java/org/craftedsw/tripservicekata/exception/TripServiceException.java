package org.craftedsw.tripservicekata.exception;

public class TripServiceException extends RuntimeException {

	private static final long serialVersionUID = 1164735052117555578L;
	
	private String errorMessage;
	
	public TripServiceException(){
		super();
	}
	
	public TripServiceException(String errorMessage){
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public TripServiceException(String errorMessage, Throwable exception){
		super(errorMessage, exception);
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage(){
		return errorMessage;
	}
}
