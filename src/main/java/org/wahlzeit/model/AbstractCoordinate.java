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
		CartesianCoordinate p1 = this.transferToCartesian();
		CartesianCoordinate p2 = coord.transferToCartesian();
		
		double delta_x = p1.getX()-p2.getX();
		double delta_y = p1.getY()-p2.getY();
		double delta_z = p1.getZ()-p2.getZ();
		
		return Math.sqrt(delta_x*delta_x + delta_y*delta_y + delta_z*delta_z);
	}
	
	@Override
	public boolean isEqual(Coordinate coord){
		CartesianCoordinate p1 = this.transferToCartesian();
		CartesianCoordinate p2 = coord.transferToCartesian();
		if (Double.compare(p1.getX(),p2.getX())== 0
			&& Double.compare(p1.getY(),p2.getY())== 0
			&& Double.compare(p1.getZ(),p2.getZ())== 0){
			return true;
		}
		return false;
	}
}
