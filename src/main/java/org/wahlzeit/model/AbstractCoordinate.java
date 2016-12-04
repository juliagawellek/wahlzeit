package org.wahlzeit.model;

/**
 * 
 * abstract class that implements a getDistance and isEqual Method for Cartesian and Spherical Coordinates
 *
 */
public abstract class AbstractCoordinate implements Coordinate {

	@Override
	public double getDistance (Coordinate coord){
		assertCoordinateNotNull(coord);
		return doGetDistance(coord);
	}
	
	protected double doGetDistance(Coordinate coord){
		
		double delta_x = this.asCartesianX()-coord.asCartesianX();
		double delta_y = this.asCartesianY()-coord.asCartesianY();
		double delta_z = this.asCartesianZ()-coord.asCartesianZ();
		
		double distance = Math.sqrt(delta_x*delta_x + delta_y*delta_y + delta_z*delta_z);
		assertValidDistance(distance);
		return distance;
		
	}
	
	@Override
	public boolean isEqual(Coordinate coord){
		assertCoordinateNotNull(coord);
		return this.getDistance(coord) < 1e-6;
	}
	
	protected void assertCoordinateNotNull(Coordinate coord) throws IllegalArgumentException {
		if (coord == null){
			throw new IllegalArgumentException("Coordinate is null!");
		}
	}
	
	protected void assertValidDistance (double distance)throws IllegalArgumentException{
		if (distance < 0){
			throw new IllegalArgumentException ("Distance must be positive!");
		}
	}
}
