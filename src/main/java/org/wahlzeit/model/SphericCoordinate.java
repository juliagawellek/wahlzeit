package org.wahlzeit.model;


public class SphericCoordinate implements Coordinate{

	/** Coordinates are given in degrees, converted into radians for distance calculation.
	 * 
	 */
	private final double latitude; //degrees
	private final double longitude; //degrees

	
	/**
	 * 
	 * @param latitude
	 * @param longitude
	 */
	public SphericCoordinate(double latitude, double longitude){
		this.latitude=latitude;
		this.longitude= longitude;
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
	 * @return Cartesian Coordinate: https://de.wikipedia.org/wiki/Kugelkoordinaten#Andere_Konventionen
	 */
	public CartesianCoordinate transferToCartesian(){
		double x = RADIUS_EARTH*Math.cos(Math.toRadians(getLatitude()))*(Math.cos(Math.toRadians(getLongitude())));
		double y = RADIUS_EARTH*Math.cos(Math.toRadians(getLatitude()))*(Math.sin(Math.toRadians(getLongitude())));
		double z = RADIUS_EARTH*Math.sin(Math.toRadians(getLatitude()));
		CartesianCoordinate transfered = new CartesianCoordinate (x,y,z);
		return transfered;
	}
	
	/**
	 * 
	 * @param p2 Coordinate
	 * @return returns distance in kilometers
	 */
	@Override
	public double getDistance (Coordinate coordinate){
		
		if (!(coordinate instanceof SphericCoordinate)){
			throw new IllegalArgumentException ("false Coordinate Type!");
		}
		
		if (this.equals(coordinate)){
			return 0.0;
		}
		
		SphericCoordinate p2= (SphericCoordinate)coordinate;
		
		//convert to radians
		double p1_latitude_rad = Math.toRadians(this.getLatitude());
		double p1_longitude_rad = Math.toRadians(this.getLongitude());
		double p2_latitude_rad = Math.toRadians(p2.getLatitude());
		double p2_longitude_rad = Math.toRadians(p2.getLongitude());
		
		
		double delta_lambda = p2_longitude_rad-p1_longitude_rad; //absolute long. difference
	
		//central angle in radians
		double delta_sigma = Math.acos(Math.sin(p1_latitude_rad)*Math.sin(p2_latitude_rad)
				+Math.cos(p1_latitude_rad)*Math.cos(p2_latitude_rad)*Math.cos(delta_lambda));
		double distance = SphericCoordinate.RADIUS_EARTH*delta_sigma;
		return distance;
		
	}
	/**
	 * 
	 * @param p2
	 * @return right, if points have same coordinates
	 */
	public boolean equals(SphericCoordinate p2){
		if (Double.compare(this.longitude,p2.longitude) == 0 && Double.compare(this.latitude,p2.latitude)== 0){
			return true;
	} return false;
	}

}

