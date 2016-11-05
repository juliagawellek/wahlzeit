package org.wahlzeit.model;

public class Location{
	
	/**
	 * Location Class
	 */
	private Coordinate coordinate;
	
	/**
	 * 
	 * @param coordinate
	 */
	public Location (Coordinate coordinate){
		if (coordinate == null){
			throw new IllegalArgumentException("Coordinate is null!");
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
