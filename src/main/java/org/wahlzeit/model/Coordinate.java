package org.wahlzeit.model;

/**
 * interface Coordinate. Enables distinction between spheric and cartesian coordinates.
 */
public interface Coordinate {
	
	public static final int RADIUS_EARTH = 6371; //kilometers 
	
	public double getDistance(Coordinate p2);


}
