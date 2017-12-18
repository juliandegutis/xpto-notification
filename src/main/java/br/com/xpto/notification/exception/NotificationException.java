package br.com.xpto.notification.exception;


public class NotificationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3058497019904712253L;
	
	public NotificationException() {}


	public NotificationException( String message, Throwable cause ) {
		super( message, cause );
	}

	public NotificationException( String message ) {
		super( message );
	}

}
