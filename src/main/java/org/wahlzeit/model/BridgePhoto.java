package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

/**
 * 
 * BridgePhoto is a subclass of Photo, in which attributes of the bridge depicted in the picture are set
 *
 */

@Subclass
public class BridgePhoto extends Photo{

	
	private String name;
	private String city;
	private int length_m; //length in meters
	private int year_built;
	
	/**
	 * constructor
	 */
	public BridgePhoto() {
		super();
	}
	
	/**
	 * constructor
	 * @param myId
	 */
	public BridgePhoto(PhotoId myId) {
		super(myId);
	}

	/**
	 * constructor
	 * sets parameters for a BridgePhoto
	 * @param name
	 * @param city
	 * @param length
	 * @param year_built
	 */
	public BridgePhoto(String name, String city, int length, int year_built){
		super();
		this.name = name;
		this.city = city;
		this.length_m = length;
		this.year_built = year_built;
	}
	
	/**
	 * 
	 * @return name of the bridge
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName (String name){
		this.name = name;
	}
	
	/**
	 * 
	 * @return name of the city
	 */
	public String getCity(){
		return city;
	}
	
	/**
	 * 
	 * @param city
	 */
	public void setCity(String city){
		this.city = city;
	}
	
	/**
	 * 
	 * @return length in meter
	 */
	public int getLength(){
		return length_m;
	}
	
	/**
	 * 
	 * @param length
	 */
	public void setLength(int length){
		this.length_m = length;
	}
	
	/**
	 * 
	 * @return year_built
	 */
	public int getYear(){
		return year_built;
	}
	
	/**
	 * 
	 * @param year
	 */
	public void setYear(int year){
		this.year_built = year;
	}
}

