package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

import com.googlecode.objectify.annotation.Subclass;

/**
 * 
 * BridgePhoto is a subclass of Photo, in which attributes of the bridge depicted in the picture are set
 *
 */

@PatternInstance(
		patternName = {"AbstractFactory"},
		participants = {"ConcreteProduct"}
		
)

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
		
		assertClassInvariants();
	}
	
	private void assertClassInvariants(){
		if (name == null || city == null || length_m<0 || year_built<0){
			throw new IllegalArgumentException ("BridgePhoto cannot be instanciated");
		}
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
		if (name == null){
			throw new IllegalArgumentException ("Name must not be null!");
		}
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
		if (city == null){
			throw new IllegalArgumentException ("City must not be null!");
		}
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
		if (length <= 0){
			throw new IllegalArgumentException ("Length must be positive");
		}
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
		if (year <= 0){
			throw new IllegalArgumentException ("Year must be positive");
		}
		this.year_built = year;
	}
}

