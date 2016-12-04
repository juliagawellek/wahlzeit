package org.wahlzeit.model;


public class SphericCoordinate extends AbstractCoordinate{

	private double latitude; //degrees
	private double longitude; //degrees
	private double radius; //kilometers

	/**
	 * 
	 * @param latitude
	 * @param longitude
	 * @param radius
	 */
	public SphericCoordinate(double latitude, double longitude, double radius){
		this.latitude=latitude;
		this.longitude= longitude;
		this.radius = radius;
	}
	
	/**
	 * 
	 * @return latitude
	 */
	public double getLatitude(){
		return latitude;
	}
	
	/**
	 * 
	 * @return longitude
	 */
	public double getLongitude(){
		return longitude;
	}
	
	/**
	 * 
	 * @return radius
	 */
	public double getRadius(){
		return radius;
	}
	
	/**
	 * 
	 * @return Cartesian Coordinate: https://de.wikipedia.org/wiki/Kugelkoordinaten#Andere_Konventionen
	 */
	@Override
	public double asCartesianX() {
		double x = radius*Math.cos(Math.toRadians(getLatitude()))*(Math.cos(Math.toRadians(getLongitude())));
		return x;
	}

	@Override
	public double asCartesianY() {
		double y = radius*Math.cos(Math.toRadians(getLatitude()))*(Math.sin(Math.toRadians(getLongitude())));
		return y;
	}

	@Override
	public double asCartesianZ() {
		double z = radius*Math.sin(Math.toRadians(getLatitude()));
		return z;
	}
	
}

