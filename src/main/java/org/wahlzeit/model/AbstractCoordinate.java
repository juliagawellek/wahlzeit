package org.wahlzeit.model;
import org.wahlzeit.model.CoordinateException;

/**
 * 
 * abstract class that implements a getDistance and isEqual Method for Cartesian and Spherical Coordinates
 *
 */
public abstract class AbstractCoordinate implements Coordinate {

	AbstractCoordinate()throws CoordinateException {
	}
	
	@Override
	public double getDistance (Coordinate coord)throws CoordinateException{
		assertCoordinateNotNull(coord);
		double distance = doGetDistance(coord);
		assertValidDistance(distance);
		return distance;
	}
	
	protected double doGetDistance(Coordinate coord){
		
		double delta_x = this.asCartesianX()-coord.asCartesianX();
		double delta_y = this.asCartesianY()-coord.asCartesianY();
		double delta_z = this.asCartesianZ()-coord.asCartesianZ();
		
		double distance = Math.sqrt(delta_x*delta_x + delta_y*delta_y + delta_z*delta_z);
		return distance;
		
	}
	
	@Override
	public boolean isEqual(Coordinate coord) throws CoordinateException{
		assertCoordinateNotNull(coord);
		return this.getDistance(coord) < 1e-6;
	}
	
	protected void assertCoordinateNotNull(Coordinate coord) throws CoordinateException {
		if (coord == null){
			throw new CoordinateException("Coordinate is null!");
		}
	}
	
	protected void assertValidDistance (double distance)throws CoordinateException{
		if (distance < 0){
			throw new CoordinateException ("Distance must be positive!");
		}
	}
	
}
