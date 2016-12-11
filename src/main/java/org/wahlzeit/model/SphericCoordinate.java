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
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);
		
		this.latitude=latitude;
		this.longitude= longitude;
		this.radius = radius;
		
		assertClassInvariant();
	}

	/**
	 * asserts whether latitude is valid
	 * @param latitude
	 * @throws IllegalArgumentException if latitude not between -90 and 90 degrees
	 */
	private void assertIsValidLatitude(double latitude)throws IllegalArgumentException {
		if (latitude < -90 || latitude > 90){
			throw new IllegalArgumentException ("Latitude must be between -90 and 90 degrees!");
		}
	}
	
	/**
	 * asserts whether longitude is valid
	 * @param longitude
	 * @throws IllegalArgumentException if longitude not between -180 and 180 degrees
	 */
	private void assertIsValidLongitude(double longitude) throws IllegalArgumentException {
		if (longitude < -180 || longitude > 180){
			throw new IllegalArgumentException ("Longitude must be between -180 and 180 degrees!");
		}
		
	}
	
	/**
	 * asserts whether longitude is valid
	 * @param radius
	 * @throws IllegalArgumentException
	 */
	private void assertIsValidRadius(double radius) throws IllegalArgumentException {
		if (radius <= 0){
			throw new IllegalArgumentException ("Radius must not not be negative or zero!");
		}	
	}
	
	/**
	 * asserts class invariants (condition that is true for any valid object)
	 */
	private void assertClassInvariant() {
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);
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
	 * @param latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
		assertIsValidLatitude(latitude);
	}

	/**
	 * 
	 * @param longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
		assertIsValidLongitude(longitude);
	}

	/**
	 * 
	 * @param radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
		assertIsValidRadius(radius);
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

