package org.wahlzeit.model;


public class Coordinate{

	/** Coordinates are given in degrees, converted into radians for distance calculation.
	 * 
	 */
	private final double latitude; //degrees
	private final double longitude; //degrees
	private static final int RADIUS_EARTH = 6371; //kilometers 
	
	/**
	 * 
	 * @param latitude
	 * @param longitude
	 */
	public Coordinate(double latitude, double longitude){
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
	 * @param p2 Coordinate
	 * @return returns distance in kilometers
	 */
	public double getDistance (Coordinate p2){
		
		if (this.equals(p2)){
			
			return 0.0;
		}
		
		//convert to radians
		double p1_latitude_rad = Math.toRadians(this.getLatitude());
		double p1_longitude_rad = Math.toRadians(this.getLongitude());
		double p2_latitude_rad = Math.toRadians(p2.getLatitude());
		double p2_longitude_rad = Math.toRadians(p2.getLongitude());
		
		
		double delta_lambda = p2_longitude_rad-p1_longitude_rad; //absolute long. difference
	
		//central angle in radians
		double delta_sigma = Math.acos(Math.sin(p1_latitude_rad)*Math.sin(p2_latitude_rad)
				+Math.cos(p1_latitude_rad)*Math.cos(p2_latitude_rad)*Math.cos(delta_lambda));
		double distance = Coordinate.RADIUS_EARTH*delta_sigma;
		return distance;
		
	}
	/**
	 * 
	 * @param p2
	 * @return right, if points have same coordinates
	 */
	public boolean equals(Coordinate p2){
		if (Double.compare(this.longitude,p2.longitude) == 0 && Double.compare(this.latitude,p2.latitude)== 0){
			return true;
	} return false;
	}
}

