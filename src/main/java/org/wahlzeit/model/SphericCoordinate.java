package org.wahlzeit.model;
import org.wahlzeit.model.CoordinateException;



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
	public SphericCoordinate(double latitude, double longitude, double radius)throws CoordinateException{
		try{
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);
		} catch (CoordinateException c){
			throw new CoordinateException("SphericCoordinate cannot be instanciated", c);
		}
		this.latitude=latitude;
		this.longitude= longitude;
		this.radius = radius;
		
		assertClassInvariant();
	}

	/**
	 * asserts whether latitude is valid
	 * @param latitude
	 * @throws throws CoordinateException if latitude not between -90 and 90 degrees
	 */
	private void assertIsValidLatitude(double latitude) throws CoordinateException {
		if (latitude < -90 || latitude > 90){
			throw new CoordinateException ("Latitude must be between -90 and 90 degrees!");
		}
	}
	
	/**
	 * asserts whether longitude is valid
	 * @param longitude
	 * @throws throws CoordinateException if longitude not between -180 and 180 degrees
	 */
	private void assertIsValidLongitude(double longitude) throws CoordinateException {
		if (longitude < -180 || longitude > 180){
			throw new CoordinateException ("Longitude must be between -180 and 180 degrees!");
		}
		
	}
	
	/**
	 * asserts whether longitude is valid
	 * @param radius
	 * @throws CoordinateException
	 */
	private void assertIsValidRadius(double radius) throws CoordinateException {
		if (radius <= 0){
			throw new CoordinateException ("Radius must not not be negative or zero!");
		}	
	}
	
	/**
	 * asserts class invariants (condition that is true for any valid object)
	 */
	private void assertClassInvariant() throws CoordinateException{
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
	public void setLatitude(double latitude)throws CoordinateException {
		this.latitude = latitude;
		assertIsValidLatitude(latitude);
	}

	/**
	 * 
	 * @param longitude
	 */
	public void setLongitude(double longitude) throws CoordinateException{
		this.longitude = longitude;
		assertIsValidLongitude(longitude);
	}

	/**
	 * 
	 * @param radius
	 */
	public void setRadius(double radius)throws CoordinateException {
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

