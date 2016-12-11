package org.wahlzeit.model;

/**
 * 
 * This exception is thrown if any unknown or incorrect operations/modifications are 
 * conducted on instances of subtypes of the coordinate interface
 *
 */
public class CoordinateException extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message error message
	 * @param cause
	 */
	public CoordinateException (String message, Throwable cause){
		super (message, cause);
	}
	
	public CoordinateException (String message){
		super (message);
	}
}
