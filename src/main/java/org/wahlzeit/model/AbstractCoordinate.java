package org.wahlzeit.model;

/**
 * 
 * abstract class that implements a getDistance and isEqual Method for Cartesian and Spherical Coordinates
 *
 */
public abstract class AbstractCoordinate implements Coordinate {

	@Override
	public double getDistance (Coordinate coord){
		if (coord == null){
			throw new IllegalArgumentException("Coordinate is null!");
		}
		return doGetDistance(coord);
	}
	
	protected double doGetDistance(Coordinate coord){
		
		double delta_x = this.asCartesianX()-coord.asCartesianX();
		double delta_y = this.asCartesianY()-coord.asCartesianY();
		double delta_z = this.asCartesianZ()-coord.asCartesianZ();
		
		return Math.sqrt(delta_x*delta_x + delta_y*delta_y + delta_z*delta_z);
	}
	
	@Override
	public boolean isEqual(Coordinate coord){
		return this.getDistance(coord) < 1e-7;
	}
}
