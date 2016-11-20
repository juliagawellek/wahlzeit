package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate{
	
	private final double x;
	private final double y;
	private final double z;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param z
	 */
	public CartesianCoordinate (double x, double y, double z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	/**
	 * 
	 * @return x
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * 
	 * @return y
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * 
	 * @return z
	 */
	public double getZ() {
		return z;
	}
	
	/**
	 * 
	 * @returns spheric coordinate: https://de.wikipedia.org/wiki/Kugelkoordinaten#Andere_Konventionen
	 */
	public SphericCoordinate transferToSpheric(){
		double latitude = Math.asin(getZ()/RADIUS_EARTH);
		double longitude = Math.atan(getY()/getX());
		SphericCoordinate transfered = new SphericCoordinate(latitude, longitude);
		return transfered;
	}

	/**
	 * 
	 * @return shortest distance, points given in cartesian coordinates
	 */
	@Override
	public double getDistance(Coordinate p2) {
		if (!(p2 instanceof CartesianCoordinate)){
			throw new IllegalArgumentException ("false Coordinate Type!");
		}
		
		CartesianCoordinate coordinate= (CartesianCoordinate)p2;
		double delta_x = coordinate.getX()-this.x;
		double delta_y = coordinate.getY()-this.y;
		double delta_z = coordinate.getZ()-this.z;
		
		return Math.sqrt(delta_x*delta_x + delta_y*delta_y + delta_z*delta_z);
	}

}
