package org.wahlzeit.model;
import org.wahlzeit.model.CoordinateException;

public class Location{
	
	/**
	 * Location Class
	 */
	private Coordinate coordinate;
	
	/**
	 * 
	 * @param coordinate
	 */
	public Location (Coordinate coordinate) throws CoordinateException{
		if (coordinate == null){
			throw new CoordinateException("Coordinate is null!");
		}
		this.coordinate = coordinate;
	}
	
	/**
	 * 
	 * @return Coordinate
	 */
	public Coordinate getCoordinate(){
		return coordinate;
	}

}
