package org.wahlzeit.model;


public class SphericCoordinate extends AbstractCoordinate{

	private final double latitude; //degrees
	private final double longitude; //degrees
	private final double radius; //kilometers

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
	public CartesianCoordinate transferToCartesian(){
		double x = radius*Math.cos(Math.toRadians(getLatitude()))*(Math.cos(Math.toRadians(getLongitude())));
		double y = radius*Math.cos(Math.toRadians(getLatitude()))*(Math.sin(Math.toRadians(getLongitude())));
		double z = radius*Math.sin(Math.toRadians(getLatitude()));
		return new CartesianCoordinate (x,y,z);
	}
	
}

