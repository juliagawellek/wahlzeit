package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

/**
 * 
 * BridgePhoto is a subclass of Photo, in which attributes of the bridge depicted in the picture are set
 *
 */
@Subclass
public class BridgePhoto extends Photo{

	private static String name;
	protected static String city;
	protected static int length_m; //length in meters
	protected static int year_built;
	
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
	 * sets parameters for a BridgePhoto
	 * @param name
	 * @param city
	 * @param length
	 * @param year_built
	 */
	public void setBridgePhoto(String name, String city, int length, int year_built){
		BridgePhoto.name = name;
		BridgePhoto.city = city;
		BridgePhoto.length_m = length;
		BridgePhoto.year_built = year_built;
	}
	
	/**
	 * 
	 * @return name of the bridge
	 */
	protected String getName(){
		return BridgePhoto.name;
	}	
}

