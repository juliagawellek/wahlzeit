package org.wahlzeit.model;

/**
 * interface Coordinate. Enables distinction between spheric and cartesian coordinates.
 */
public interface Coordinate{
		
	/**
	 * 
	 * @param p2
	 * @return shortest distance between to points
	 * @throws CoordinateException 
	 */
	public double getDistance(Coordinate p2) throws CoordinateException;
	
	/**
	 * 
	 * @param p2
	 * @return yes, if two Coordinates are identical
	 * @throws CoordinateException 
	 */
	public boolean isEqual(Coordinate p2) throws CoordinateException;
	
	/**
	 * 
	 * @return x-component of cartesian coordinate
	 */
	public double asCartesianX();
	
	/**
	 * 
	 * @return y-component of cartesian coordinate
	 */
	public double asCartesianY();
	
	/**
	 * 
	 * @return z-component of cartesian coordinate
	 */
	public double asCartesianZ();

}
