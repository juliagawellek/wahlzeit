package org.wahlzeit.model;

/**
 * interface Coordinate. Enables distinction between spheric and cartesian coordinates.
 */
public interface Coordinate{
		
	/**
	 * 
	 * @param p2
	 * @return shortest distance between to points
	 */
	public double getDistance(Coordinate p2);
	
	/**
	 * 
	 * @param p2
	 * @return yes, if two Coordinates are identical
	 */
	public boolean isEqual(Coordinate p2);
	
	/**
	 * 
	 * @param 
	 * @return cartesian representation of a spheric coordinate
	 */
	public CartesianCoordinate transferToCartesian ();

}
