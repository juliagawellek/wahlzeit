package org.wahlzeit.model;

import org.wahlzeit.model.CoordinateException;
import java.util.HashMap;

public class SphericCoordinate extends AbstractCoordinate{

	private final double latitude; //degrees
	private final double longitude; //degrees
	private final double radius; //kilometers

	private static HashMap<Integer, SphericCoordinate> sphericInstances = new HashMap<>();
	
	/**
	 * 
	 * @param latitude
	 * @param longitude
	 * @param radius
	 */
	private SphericCoordinate(double latitude, double longitude, double radius)throws CoordinateException{
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
	 * returns spheric coords with given values.
	 * If instance with given values does not exist, it is inserted into the hashmap and is returned
	 * 
	 * @param latitude
	 * @param longitude
	 * @param radius
	 * @return SphericCoordinate
	 * @throws CoordinateException
	 */
	public static SphericCoordinate getInstance (double latitude, double longitude, double radius) throws CoordinateException{
		SphericCoordinate sphericCoord = new SphericCoordinate (latitude,longitude,radius);
		synchronized (sphericInstances){
			if (!sphericInstances.containsValue(sphericCoord)){
				sphericInstances.put(sphericCoord.hashCode(), sphericCoord);
			}
			return sphericInstances.get(sphericCoord);
		}
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

